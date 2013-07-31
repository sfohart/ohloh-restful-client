package br.ufba.dcc.mestrado.computacao.ohloh.crawler;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.log4j.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProject;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.client.OhLohRestfulClient;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohProjectResponse;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohProjectQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohProjectRepository;

@Singleton
@Named
public class OhLohCrawler {
	
	private static final String OHLOH_PROJECT_SORT_BY_ID = "id";

	public static Logger logger = Logger.getLogger(OhLohCrawler.class);
	
	@Inject
	private OhLohRestfulClient ohLohRestfulClient;
	
	@Inject
	@OhLohProjectQualifier
	private OhLohProjectRepository projectRepository;
	
	public OhLohRestfulClient getOhLohRestfulClient() {
		return ohLohRestfulClient;
	}

	public void setOhLohRestfulClient(OhLohRestfulClient ohLohRestfulClient) {
		this.ohLohRestfulClient = ohLohRestfulClient;
	}

	public OhLohProjectRepository getProjectRepository() {
		return projectRepository;
	}

	public void setProjectRepository(OhLohProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public OhLohCrawler() {
	}
	
	public void run() throws Exception {
		OhLohBaseRequest request = new OhLohBaseRequest();
		Integer totalPages = 0;
		Integer page = 1;
		
		request.setSort(OHLOH_PROJECT_SORT_BY_ID);
		
		do {
			request.setPage(page);
			OhLohProjectResponse response = ohLohRestfulClient.getAllProjects(request);
			
			if (totalPages <= 0) {
				totalPages = response.getItemsAvailable() / response.getItemsReturned();
				logger.info(String.format("Total Pages: %d", totalPages));
			}
			
			if (OhLohProjectResponse.SUCCESS.equals(response.getStatus())) {
				logger.info(String.format("Page: %d", page));
				
				List<OhLohProject> ohLohProjects = response.getResult().getOhLohProjects();
				if (ohLohProjects != null && ! ohLohProjects.isEmpty()) {
					for (OhLohProject project : ohLohProjects) {
						StringBuffer buffer = new StringBuffer();
						buffer.append(String.format("Project Name: %s \n", project.getName()));
						buffer.append(String.format("Project URL: %s \n\n", project.getUrl()));
						
						System.out.println(buffer.toString());
						
						projectRepository.add(project);
					}
				}
				
			} else {
				break;
			}
			
			
			page++;
			
		} while (page < totalPages);
	}
	
	public static void main(String[] args) throws Exception {
		WeldContainer container = new Weld().initialize();
		OhLohCrawler crawler = container.instance().select(OhLohCrawler.class).get();
		
		if (crawler != null) {
			logger.info(String.format("OhLoh API KEY: %s", crawler.getOhLohRestfulClient().getApiKey()));
			
			List<OhLohProject> ohLohProjects = crawler.getProjectRepository().findAll();
			crawler.run();
		}
		
		/*OhLohCrawler crawler = new OhLohCrawler();
		crawler.run();*/
	}

}
