package br.ufba.dcc.mestrado.computacao.ohloh.crawler;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.log4j.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysisDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerAnalysisEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.client.OhLohRestfulClient;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohAnalysisServiceQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohCrawlerAnalysisRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohProjectServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohCrawlerAnalysisRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohAnalysisService;
import br.ufba.dcc.mestrado.computacao.service.OhLohProjectService;

@Singleton
@Named
public class OhLohAnalysisCrawler {
	
	private static final String OHLOH_PROJECT_SORT_BY_ID = "id";

	public static Logger logger = Logger.getLogger(OhLohAnalysisCrawler.class);
	
	@Inject
	private OhLohRestfulClient ohLohRestfulClient;
	
	@Inject
	@OhLohAnalysisServiceQualifier
	private OhLohAnalysisService ohLohAnalysisService;
	
	@Inject
	@OhLohProjectServiceQualifier
	private OhLohProjectService ohLohProjectService;
	
	@Inject
	@OhLohCrawlerAnalysisRepositoryQualifier
	private OhLohCrawlerAnalysisRepository crawlerConfigRepository;
	
	public OhLohRestfulClient getOhLohRestfulClient() {
		return ohLohRestfulClient;
	}

	public void setOhLohRestfulClient(OhLohRestfulClient ohLohRestfulClient) {
		this.ohLohRestfulClient = ohLohRestfulClient;
	}

	public OhLohAnalysisService getOhLohAnalysisService() {
		return ohLohAnalysisService;
	}
	
	public void setOhLohAnalysisService(
			OhLohAnalysisService ohLohAnalysisService) {
		this.ohLohAnalysisService = ohLohAnalysisService;
	}

	public OhLohAnalysisCrawler() {
	}
	
	public void run() throws Exception {
		
		Integer startAt = 0;
		Integer offset = 10;
		Long totalProjects = 0L;
		
		OhLohCrawlerAnalysisEntity config = new OhLohCrawlerAnalysisEntity();
		
		List<OhLohCrawlerAnalysisEntity> configList = 
				crawlerConfigRepository.findAll();
		
		if (configList != null && ! configList.isEmpty()) {
			config = configList.get(0);
			
			if (config.getStartAt() != null) {
				startAt = config.getStartAt();
			}
			
			if (config.getOffset() != null) {
				offset = config.getOffset();
			}
			
			totalProjects = ohLohProjectService.countAll();
			config.setTotalProjects(totalProjects);
		}
		
		
		try {
			do {
				
				List<OhLohProjectEntity> projectList = ohLohProjectService.findAll(startAt, offset);
				if (projectList != null && ! projectList.isEmpty()) {
					for (OhLohProjectEntity project : projectList) {
						
						OhLohAnalysisDTO analysisDTO = ohLohRestfulClient.getLatestAnalysis(String.valueOf(project.getId()), null);
						if ( (analysisDTO != null) && (ohLohAnalysisService.findById(analysisDTO.getId()) == null)) {
							logger.info(String.format("Analysis com id %d para o projeto \"%s\" sendo gravado", analysisDTO.getId(), project.getName()));
							ohLohAnalysisService.store(analysisDTO);
						}
						
					}
				}
				
				config.setOffset(offset);
				config.setStartAt(startAt);
				crawlerConfigRepository.save(config);
				
				startAt += offset;
				config.setStartAt(startAt);	
				
				
			} while (startAt < totalProjects);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			crawlerConfigRepository.save(config);
		}
	}
	
	public static void main(String[] args) throws Exception {
		WeldContainer container = new Weld().initialize();
		OhLohAnalysisCrawler crawler = container.instance().select(OhLohAnalysisCrawler.class).get();
		
		if (crawler != null) {
			crawler.run();
		}
		
		/*OhLohProjectCrawler crawler = new OhLohProjectCrawler();
		crawler.run();*/
	}

}
