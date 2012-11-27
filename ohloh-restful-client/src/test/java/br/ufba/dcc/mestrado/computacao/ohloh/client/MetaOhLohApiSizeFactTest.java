package br.ufba.dcc.mestrado.computacao.ohloh.client;

import org.junit.Test;

import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohSizeFactResponse;

public class MetaOhLohApiSizeFactTest extends AbstractOhLohApiTest {

	@Test
	public void testSuccessGetSizeFact() {
		OhLohSizeFactResponse resource = getOhLohRestfulClient().getLatestSizeFackByProject("maven2", new OhLohBaseRequest());
		org.junit.Assert.assertEquals("success", resource.getStatus());
		
	}
	
	@Test
	public void testSuccessGetLatestSizeFact() {
		OhLohSizeFactResponse resource = getOhLohRestfulClient().getAnalysizSizeFactByProject("maven2", "11260404", new OhLohBaseRequest());
		org.junit.Assert.assertEquals("success", resource.getStatus());
	}
	
}
