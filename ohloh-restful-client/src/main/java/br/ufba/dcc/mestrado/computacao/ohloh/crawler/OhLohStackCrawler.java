package br.ufba.dcc.mestrado.computacao.ohloh.crawler;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.ufba.dcc.mestrado.computacao.ohloh.data.stack.OhLohStackDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.stack.OhLohStackEntryDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.client.OhLohRestfulClient;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohProjectServiceQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohStackServiceQualifier;
import br.ufba.dcc.mestrado.computacao.service.OhLohProjectService;
import br.ufba.dcc.mestrado.computacao.service.OhLohStackService;

public class OhLohStackCrawler {
	

	public static Logger logger = Logger.getLogger(OhLohStackCrawler.class);

	@Inject
	private OhLohRestfulClient ohLohRestfulClient;
	
	@Inject
	@OhLohProjectServiceQualifier
	private OhLohProjectService projectService;
	
	@Inject
	@OhLohStackServiceQualifier
	private OhLohStackService stackService;
	
	public void run() throws Exception {
		OhLohBaseRequest request = new OhLohBaseRequest();
		
		
		
		try {
			Long totalProjects = totalProjects = projectService.countAll();
			Integer totalProjectPages = 0;
			Integer offsetAccount = 10;
			Integer startAtAccount = 0;
			
			List<OhLohProjectEntity> projectList = null;
			
			do {
				//pegando listas de contas
				projectList = projectService.findAll(startAtAccount, offsetAccount);
				
				if (projectList != null && ! projectList.isEmpty()) {
					for (OhLohProjectEntity project : projectList) {
						//buscando stack pra cada conta
						List<OhLohStackDTO> stackDTOList = ohLohRestfulClient.getProjectStacks(project.getId().toString(), request);
						
						if (stackDTOList != null && ! stackDTOList.isEmpty()) {
							
							//armazenando cada stack obtido para esta conta na base de dados
							for (OhLohStackDTO stackDTO :  stackDTOList) {
								stackService.store(stackDTO);
							}
						}
					}
				}
			} while (projectList != null && ! projectList.isEmpty());
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		WeldContainer container = new Weld().initialize();
		OhLohStackCrawler crawler = container.instance().select(OhLohStackCrawler.class).get();
		
		if (crawler != null) {
			crawler.run();
		}
		
	}
}
