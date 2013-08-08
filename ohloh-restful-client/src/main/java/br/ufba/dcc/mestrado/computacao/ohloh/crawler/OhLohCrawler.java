package br.ufba.dcc.mestrado.computacao.ohloh.crawler;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.log4j.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerConfigEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.client.OhLohRestfulClient;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohProjectResponse;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohCrawlerConfigRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohProjectServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohCrawlerConfigRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohProjectService;

@Singleton
@Named
public class OhLohCrawler {
	
	private static final String OHLOH_PROJECT_SORT_BY_ID = "id";

	public static Logger logger = Logger.getLogger(OhLohCrawler.class);
	
	@Inject
	private OhLohRestfulClient ohLohRestfulClient;
	
	@Inject
	@OhLohProjectServiceQualifier
	private OhLohProjectService ohLohProjectService;
	
	@Inject
	@OhLohCrawlerConfigRepositoryQualifier
	private OhLohCrawlerConfigRepository crawlerConfigRepository;
	
	public OhLohRestfulClient getOhLohRestfulClient() {
		return ohLohRestfulClient;
	}

	public void setOhLohRestfulClient(OhLohRestfulClient ohLohRestfulClient) {
		this.ohLohRestfulClient = ohLohRestfulClient;
	}

	public OhLohProjectService getOhLohProjectService() {
		return ohLohProjectService;
	}
	
	public void setOhLohProjectService(OhLohProjectService ohLohProjectService) {
		this.ohLohProjectService = ohLohProjectService;
	}

	public OhLohCrawler() {
	}
	
	public void run() throws Exception {
		OhLohBaseRequest request = new OhLohBaseRequest();
		Integer totalPages = 0;
		Integer page = 1;
		
		request.setSort(OHLOH_PROJECT_SORT_BY_ID);
		
		OhLohCrawlerConfigEntity config = new OhLohCrawlerConfigEntity();
		
		List<OhLohCrawlerConfigEntity> configList = 
				crawlerConfigRepository.findAll();
		
		if (configList != null && ! configList.isEmpty()) {
			config = configList.get(0);
			page = config.getProjectCurrentPage();
		}
		
		
		try {
			do {
				request.setPage(page);
				OhLohProjectResponse response = ohLohRestfulClient.getAllProjects(request);
				logger.info(String.format("Total Pages: %d | Total Projects: %d", totalPages, ohLohProjectService.countAll()));
				
				if (totalPages <= 0 && response.getItemsAvailable() != null && response.getItemsReturned() != null) {
					totalPages = response.getItemsAvailable() / response.getItemsReturned();
					config.setProjectTotalPage(totalPages);
				}
				
				if (OhLohProjectResponse.SUCCESS.equals(response.getStatus())) {
					List<OhLohProjectDTO> ohLohProjectDTOs = response.getResult().getOhLohProjects();
					if (ohLohProjectDTOs != null && ! ohLohProjectDTOs.isEmpty()) {
						logger.info(String.format("Page: %d | Projects: %d", page, ohLohProjectDTOs.size()));
						for (OhLohProjectDTO project : ohLohProjectDTOs) {
							ohLohProjectService.store(project);
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
		
		/*OhLohCrawler crawler = new OhLohCrawler();
		crawler.run();*/
	}

}
