package br.ufba.dcc.mestrado.computacao.ohloh.client;

import java.util.List;

import org.junit.Test;

import br.ufba.dcc.mestrado.computacao.ohloh.data.stack.OhLohStackDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;

public class MetaOhLohApiStackTest extends AbstractOhLohApiTest {

	@Test
	public void testSuccessGetProjectStack() {
		List<OhLohStackDTO> response = getOhLohRestfulClient().getProjectStacks("maven2", new OhLohBaseRequest());
		org.junit.Assert.assertNotNull(response);
	}
	
	@Test
	public void testSuccessGetAccountStack() {
		OhLohStackDTO stack = getOhLohRestfulClient().getSingleAccountStack("sfohart", "105181", new OhLohBaseRequest());
		org.junit.Assert.assertNotNull(stack);
	}
	
	@Test
	public void testSuccessGetAccountDefaultStack() {
		OhLohStackDTO stack = getOhLohRestfulClient().getDefaultAccountStack("sfohart", new OhLohBaseRequest());
		org.junit.Assert.assertNotNull(stack);
	}
	
}
