package br.ufba.dcc.mestrado.computacao.ohloh.client;

import org.junit.Test;

import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysisDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;


public class MetaOhLohApiAnalysisTest extends AbstractOhLohApiTest {

	@Test
	public void testGetLatestAnalysis() {
		OhLohAnalysisDTO resource = getOhLohRestfulClient().getLatestAnalysis("maven2", new OhLohBaseRequest());
		org.junit.Assert.assertNotNull(resource);
	}
	
	@Test
	public void testGetAnalysisById() {
		OhLohAnalysisDTO resource = getOhLohRestfulClient().getAnalysisById("maven2", "14696526", new OhLohBaseRequest());
		org.junit.Assert.assertNotNull(resource);
	}
	
	
}
