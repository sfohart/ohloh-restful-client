package br.ufba.dcc.mestrado.computacao.ohloh.crawler;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProject;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.client.OhLohRestfulClient;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohProjectResponse;
import br.ufba.dcc.mestrado.computacao.qualifier.ConfigurationValue;

public class OhLohCrawler {
	
	private static final String OHLOH_PROJECT_SORT_BY_ID = "id";

	Logger logger = Logger.getLogger(OhLohCrawler.class);
	
	@Inject
	private OhLohRestfulClient ohLohRestfulClient;
	
	protected OhLohRestfulClient getOhLohRestfulClient() {
		return ohLohRestfulClient;
	}
	
	public OhLohCrawler() {
	}
	
	public void run() {
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
					}
				}
				
			} else {
				break;
			}
			
			
			page++;
			
		} while (page < totalPages);
	}
	
	public static void main(String[] args) {
		WeldContainer container = new Weld().initialize();
		OhLohCrawler crawler = container.instance().select(OhLohCrawler.class).get();
		
		if (crawler != null) {
			System.out.println(crawler.getOhLohRestfulClient().getApiKey());
		}
		
		/*OhLohCrawler crawler = new OhLohCrawler();
		crawler.run();*/
	}

}
