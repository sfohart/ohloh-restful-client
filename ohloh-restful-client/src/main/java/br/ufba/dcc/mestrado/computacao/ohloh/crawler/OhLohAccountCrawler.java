package br.ufba.dcc.mestrado.computacao.ohloh.crawler;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import br.ufba.dcc.mestrado.computacao.ohloh.data.account.OhLohAccountDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerAccountEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.client.OhLohRestfulClient;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohAccountResponse;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohAccountServiceQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohCrawlerAccountRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohCrawlerAccountRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohAccountService;

public class OhLohAccountCrawler {
	
	private static final String OHLOH_PROJECT_SORT_BY_ID = "id";

	public static Logger logger = Logger.getLogger(OhLohAccountCrawler.class);

	@Inject
	private OhLohRestfulClient ohLohRestfulClient;
	
	@Inject
	@OhLohCrawlerAccountRepositoryQualifier
	private OhLohCrawlerAccountRepository crawlerAccountRepository;
	
	@Inject
	@OhLohAccountServiceQualifier
	private OhLohAccountService accountService;
	
	public void run() throws Exception {
		OhLohBaseRequest request = new OhLohBaseRequest();
		Integer totalPages = 0;
		Integer page = 1;
		
		request.setSort(OHLOH_PROJECT_SORT_BY_ID);
		
		OhLohCrawlerAccountEntity config =  crawlerAccountRepository.findCrawlerConfig();
		
		if (config != null) {
			if (config.getAccountCurrentPage() != null) {
				page = config.getAccountCurrentPage();
			}
		} else {
			config = new OhLohCrawlerAccountEntity();
		}
		
		try {
			do {
				request.setPage(page);
				OhLohAccountResponse response = ohLohRestfulClient.getAllAccounts(request);
				logger.info(String.format("Total Pages: %d | Total Account: %d", totalPages, accountService.countAll()));
				
				
				if (totalPages <= 0 && response.getItemsAvailable() != null && response.getItemsReturned() != null) {
					totalPages = response.getItemsAvailable() / response.getItemsReturned();
					config.setAccountTotalPage(totalPages);
				}
				
				if (OhLohAccountResponse.SUCCESS.equals(response.getStatus())) {
					List<OhLohAccountDTO> ohLohAccountDTOs = response.getResult().getOhLohAccounts();
					if (ohLohAccountDTOs != null && ! ohLohAccountDTOs.isEmpty()) {
						logger.info(String.format("Page: %d | Accounts: %d", page, ohLohAccountDTOs.size()));
						for (OhLohAccountDTO account : ohLohAccountDTOs) {
							if (accountService.findById(account.getId()) == null) {
								accountService.store(account);
							} else {
								logger.info(String.format("Conta \"%s\" com id %d já se encontra na base", account.getName(), account.getId()));
							}
							
						}
					}
					
				} else {
					throw new IllegalStateException("OhLoh response status: " + response.getStatus() + ". " + response.getError());
				}
				
				
				page++;
			
				config.setAccountCurrentPage(page);
				crawlerAccountRepository.save(config);
				
			} while (page < totalPages);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			crawlerAccountRepository.save(config);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		WeldContainer container = new Weld().initialize();
		OhLohAccountCrawler crawler = container.instance().select(OhLohAccountCrawler.class).get();
		
		if (crawler != null) {
			crawler.run();
		}
		
	}

}
