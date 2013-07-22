package br.ufba.dcc.mestrado.computacao.ohloh.client;

import org.junit.Test;

import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohFactoidResponse;


public class MetaOhLohApiFactoidTest extends AbstractOhLohApiTest {

	@Test
	public void testAllFactoidsByProject() {
		OhLohFactoidResponse resource = getOhLohRestfulClient().getAllFactoidsByProject("maven2", new OhLohBaseRequest());
		org.junit.Assert.assertEquals("success", resource.getStatus());
	}
	
	@Test
	public void testSuccessGetProjectFactoid() {
		OhLohFactoidResponse resource = getOhLohRestfulClient().getSingleFactoidByProject("maven2", "53351233", new OhLohBaseRequest());
		org.junit.Assert.assertEquals("success", resource.getStatus());
	}
	
	
}
