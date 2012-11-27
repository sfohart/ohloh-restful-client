package br.ufba.dcc.mestrado.computacao.ohloh.client;

import org.junit.Test;

import br.ufba.dcc.mestrado.computacao.ohloh.data.stack.OhLohStack;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohBaseResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohStackResponse;

public class MetaOhLohApiStackTest extends AbstractOhLohApiTest {

	@Test
	public void testSuccessGetProjectStack() {
		OhLohStackResponse response = getOhLohRestfulClient().getProjectStacks("maven2", new OhLohBaseRequest());
		org.junit.Assert.assertEquals(OhLohBaseResponse.SUCCESS, response.getStatus());
	}
	
	@Test
	public void testSuccessGetAccountStack() {
		OhLohStack stack = getOhLohRestfulClient().getSingleAccountStack("sfohart", "105181", new OhLohBaseRequest());
		org.junit.Assert.assertNotNull(stack);
	}
	
	@Test
	public void testSuccessGetAccountDefaultStack() {
		OhLohStack stack = getOhLohRestfulClient().getDefaultAccountStack("sfohart", new OhLohBaseRequest());
		org.junit.Assert.assertNotNull(stack);
	}
	
}
