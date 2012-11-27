package br.ufba.dcc.mestrado.computacao;

import org.junit.Test;

import br.ufba.dcc.mestrado.computacao.ohloh.data.enlistment.OhLohEnlistment;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohBaseResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohEnlistmentResponse;

public class MetaOhLohApiEnlistmentTest extends AbstractOhLohApiTest {

	@Test
	public void testGetAllProjectEnlistments() {
		OhLohEnlistmentResponse response = getOhLohRestfulClient().getAllProjectEnlistments("maven2", new OhLohBaseRequest());
		org.junit.Assert.assertEquals(OhLohBaseResponse.SUCCESS, response.getStatus());
	}
	
	@Test
	public void testGetProjectEnlistmentById() {
		OhLohEnlistment enlistment = getOhLohRestfulClient().getProjectEnlistmentById("maven2", "506120");
		org.junit.Assert.assertNotNull(enlistment);
	}
	
}
