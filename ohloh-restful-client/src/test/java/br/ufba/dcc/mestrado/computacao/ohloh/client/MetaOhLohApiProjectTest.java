package br.ufba.dcc.mestrado.computacao.ohloh.client;

import org.junit.Test;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProject;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohProjectResponse;

public class MetaOhLohApiProjectTest extends AbstractOhLohApiTest {

	@Test
	public void testSuccessGetProject() {
		OhLohProject resource = getOhLohRestfulClient().getProject("maven2", new OhLohBaseRequest());
		org.junit.Assert.assertNotNull(resource);
	}
	
	//@Test
	public void testSuccessGetAllProject() {
		OhLohProjectResponse resource = getOhLohRestfulClient().getAllProjects(new OhLohBaseRequest());
		org.junit.Assert.assertEquals("success", resource.getStatus());
	}
	
}
