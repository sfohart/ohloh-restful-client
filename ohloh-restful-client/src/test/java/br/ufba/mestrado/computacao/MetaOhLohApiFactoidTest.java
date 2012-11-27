package br.ufba.mestrado.computacao;

import org.junit.Test;

import br.ufba.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.mestrado.computacao.ohloh.restful.responses.OhLohFactoidResponse;


public class MetaOhLohApiFactoidTest extends AbstractOhLohApiTest {

	@Test
	public void testAllFactoidsByProject() {
		OhLohFactoidResponse resource = getOhLohRestfulClient().getAllFactoidsByProject("maven2", new OhLohBaseRequest());
		org.junit.Assert.assertEquals("success", resource.getStatus());
	}
	
	@Test
	public void testSuccessGetProjectFactoid() {
		OhLohFactoidResponse resource = getOhLohRestfulClient().getSingleFactoidByProject("maven2", "34999042", new OhLohBaseRequest());
		org.junit.Assert.assertEquals("success", resource.getStatus());
	}
	
	
}