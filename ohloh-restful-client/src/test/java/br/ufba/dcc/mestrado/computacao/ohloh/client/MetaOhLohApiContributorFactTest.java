package br.ufba.dcc.mestrado.computacao.ohloh.client;

import org.junit.Test;

import br.ufba.dcc.mestrado.computacao.ohloh.data.contributorfact.OhLohContributorFactDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohBaseResponse;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.responses.OhLohContributorFactResponse;

public class MetaOhLohApiContributorFactTest extends AbstractOhLohApiTest {

	@Test
	public void testGetAllProjectContributorFacts() {
		OhLohContributorFactResponse response = getOhLohRestfulClient().getAllProjectContributorFacts("maven2", new OhLohBaseRequest());
		org.junit.Assert.assertEquals(OhLohBaseResponse.SUCCESS, response.getStatus());
	}
	
	@Test
	public void testGetProjectContributorFactById() {
		OhLohContributorFactDTO contributorFact = getOhLohRestfulClient().getProjectContributorFactById("maven2", "15028090575377", new OhLohBaseRequest());
		org.junit.Assert.assertNotNull(contributorFact);
	}
	
}
