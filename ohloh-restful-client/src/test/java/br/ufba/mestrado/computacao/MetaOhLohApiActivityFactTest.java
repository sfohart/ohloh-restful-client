package br.ufba.mestrado.computacao;

import org.junit.Test;

import br.ufba.mestrado.computacao.ohloh.restful.responses.OhLohActivityFactResponse;
import br.ufba.mestrado.computacao.ohloh.restful.responses.OhLohBaseResponse;

public class MetaOhLohApiActivityFactTest extends AbstractOhLohApiTest {

	@Test
	public void testGetProjectActivityFactsByAnalysisId() {
		OhLohActivityFactResponse response = getOhLohRestfulClient().getProjectActivityFactByAnalysisId("maven2", "11371710");
		org.junit.Assert.assertEquals(OhLohBaseResponse.SUCCESS, response.getStatus());
	}
	
	@Test
	public void testGetLatestProjectActivityFacts() {
		OhLohActivityFactResponse response = getOhLohRestfulClient().getLatestProjectActivityFacts("maven2");
		org.junit.Assert.assertEquals(OhLohBaseResponse.SUCCESS, response.getStatus());
	}
}
