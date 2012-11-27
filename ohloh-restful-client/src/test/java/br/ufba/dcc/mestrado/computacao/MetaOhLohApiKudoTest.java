package br.ufba.dcc.mestrado.computacao;

import org.junit.Test;

import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohBaseResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohKudoResponse;

public class MetaOhLohApiKudoTest extends AbstractOhLohApiTest {

	@Test
	public void testGetAllKudosReceivedByAccountId() {
		OhLohKudoResponse response = getOhLohRestfulClient().getAllKudoReceivedByAccountId("1");
		org.junit.Assert.assertEquals(OhLohBaseResponse.SUCCESS, response.getStatus());
	}
	
	@Test
	public void testGetAllKudosSentByAccountId() {
		OhLohKudoResponse response = getOhLohRestfulClient().getAllKudoSentByAccountId("1");
		org.junit.Assert.assertEquals(OhLohBaseResponse.SUCCESS, response.getStatus());
	}
	
}
