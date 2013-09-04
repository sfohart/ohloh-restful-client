package br.ufba.dcc.mestrado.computacao.ohloh.crawler;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysisDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.stack.OhLohStackDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerProjectEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.client.OhLohRestfulClient;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohProjectResponse;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohCrawlerProjectRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohAnalysisServiceQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohProjectServiceQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohStackServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohCrawlerProjectRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohAnalysisService;
import br.ufba.dcc.mestrado.computacao.service.OhLohProjectService;
import br.ufba.dcc.mestrado.computacao.service.OhLohStackService;

public class OhLohCrawler {

	private static final String OHLOH_PROJECT_SORT_BY_ID = "id";

	public static Logger logger = Logger.getLogger(OhLohCrawler.class);
	
	@Inject
	private OhLohRestfulClient restfulClient;
	
	@Inject
	@OhLohProjectServiceQualifier
	private OhLohProjectService projectService;
	
	@Inject
	@OhLohStackServiceQualifier
	private OhLohStackService stackService;
	
	@Inject
	@OhLohAnalysisServiceQualifier
	private OhLohAnalysisService analysisService;
	
	@Inject
	@OhLohCrawlerProjectRepositoryQualifier
	private OhLohCrawlerProjectRepository crawlerConfigRepository;
	
	public OhLohRestfulClient getRestfulClient() {
		return restfulClient;
	}
	
	public void setRestfulClient(OhLohRestfulClient restfulClient) {
		this.restfulClient = restfulClient;
	}

	public OhLohProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(OhLohProjectService projectService) {
		this.projectService = projectService;
	}

	public OhLohStackService getStackService() {
		return stackService;
	}

	public void setStackService(OhLohStackService stackService) {
		this.stackService = stackService;
	}

	public OhLohAnalysisService getAnalysisService() {
		return analysisService;
	}

	public void setAnalysisService(OhLohAnalysisService analysisService) {
		this.analysisService = analysisService;
	}

	public OhLohCrawlerProjectRepository getCrawlerConfigRepository() {
		return crawlerConfigRepository;
	}

	public void setCrawlerConfigRepository(
			OhLohCrawlerProjectRepository crawlerConfigRepository) {
		this.crawlerConfigRepository = crawlerConfigRepository;
	}

	protected void downloadAnalysis(OhLohProjectEntity project) throws Exception {
		OhLohAnalysisDTO analysisDTO = getRestfulClient().getLatestAnalysis(String.valueOf(project.getId()), null);
		if ( (analysisDTO != null) && (getAnalysisService().findById(analysisDTO.getId()) == null)) {
			logger.info(String.format("Analysis com id %d para o projeto \"%s\" sendo gravado", analysisDTO.getId(), project.getName()));
			getAnalysisService().store(analysisDTO);
		}
	}
	
	protected void downloadStack(OhLohProjectEntity project) throws Exception {
		
		OhLohBaseRequest request = new OhLohBaseRequest();
		
		if (project != null && project.getId() != null) {
			List<OhLohStackDTO> stackDTOList = getRestfulClient().getProjectStacks(project.getId().toString(), request);
			
			if (stackDTOList != null && ! stackDTOList.isEmpty()) {
				
				//armazenando cada stack obtido para esta conta na base de dados
				for (OhLohStackDTO stackDTO :  stackDTOList) {
					getStackService().store(stackDTO);
				}
			}
		}
	}
	
	public void run() throws Exception {
		OhLohBaseRequest request = new OhLohBaseRequest();
		Integer totalPages = 0;
		Integer page = 1;
		
		request.setSort(OHLOH_PROJECT_SORT_BY_ID);
		
		OhLohCrawlerProjectEntity config = new OhLohCrawlerProjectEntity();
		
		List<OhLohCrawlerProjectEntity> configList = 
				crawlerConfigRepository.findAll();
		
		if (configList != null && ! configList.isEmpty()) {
			config = configList.get(0);
			page = config.getProjectCurrentPage();
		}
		
		try {
			do {
				//configurando requisi��o
				request.setPage(page);
				
				//efetuando requisi��o
				OhLohProjectResponse response = getRestfulClient().getAllProjects(request);
				logger.info(String.format("Total Pages: %d | Total Projects: %d", totalPages, getProjectService().countAll()));
				
				//atualizando 
				if (totalPages <= 0 && response.getItemsAvailable() != null && response.getItemsReturned() != null) {
					totalPages = response.getItemsAvailable() / response.getItemsReturned();
					config.setProjectTotalPage(totalPages);
				}
				
				//projetos baixados com sucesso
				if (OhLohProjectResponse.SUCCESS.equals(response.getStatus())) {
					List<OhLohProjectDTO> ohLohProjectDTOs = response.getResult().getOhLohProjects();
					
					if (ohLohProjectDTOs != null && ! ohLohProjectDTOs.isEmpty()) {
						logger.info(String.format("Page: %d | Projects: %d", page, ohLohProjectDTOs.size()));
						for (OhLohProjectDTO project : ohLohProjectDTOs) {
							OhLohProjectEntity projectEntity = getProjectService().findById(project.getId());
							
							//armazenando os projetos na base de dados
							if (projectEntity == null) {
								projectEntity = getProjectService().store(project);
							} else {
								logger.info(String.format("Projeto \"%s\" com id %d j� se encontra na base", project.getName(), project.getId()));
							}
							
							//baixando os stacks do projeto
							downloadStack(projectEntity);
							
							//baixando as an�lises do projeto
							downloadAnalysis(projectEntity);
						}
					}
					
				} else {
					throw new IllegalStateException("OhLoh response status: " + response.getStatus() + ". " + response.getError());
				}
				
				page++;
			
				config.setProjectCurrentPage(page);
				crawlerConfigRepository.save(config);
				
			} while (page < totalPages);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			crawlerConfigRepository.save(config);
		}
	}
	
	public static void main(String[] args) throws Exception {
		WeldContainer container = new Weld().initialize();
		OhLohCrawler crawler = container.instance().select(OhLohCrawler.class).get();
		
		if (crawler != null) {
			crawler.run();
		}
		
	}
	
}
