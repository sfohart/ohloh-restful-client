package br.ufba.dcc.mestrado.computacao;

import org.junit.Test;

import br.ufba.dcc.mestrado.computacao.ohloh.data.account.OhLohAccount;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohAccountResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohBaseResponse;

public class MetaOhLohApiAccountTest extends AbstractOhLohApiTest {

	@Test
	public void testGetAccountById() {
		OhLohAccount resource = getOhLohRestfulClient().getAccountById("sfohart", new OhLohBaseRequest());		
		org.junit.Assert.assertNotNull(resource);	
	}
	
	@Test
	public void testGetAllAccount() {
		OhLohAccountResponse response = getOhLohRestfulClient().getAllAccounts(new OhLohBaseRequest());
		org.junit.Assert.assertEquals(OhLohBaseResponse.SUCCESS, response.getStatus());
	}
	
}
