package br.ufba.mestrado.computacao;

import org.junit.Test;

import br.ufba.mestrado.computacao.ohloh.data.analysis.OhLohAnalysis;
import br.ufba.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;


public class MetaOhLohApiAnalysisTest extends AbstractOhLohApiTest {

	@Test
	public void testGetLatestAnalysis() {
		OhLohAnalysis resource = getOhLohRestfulClient().getLatestAnalysis("maven2", new OhLohBaseRequest());
		org.junit.Assert.assertNotNull(resource);
	}
	
	@Test
	public void testGetAnalysisById() {
		OhLohAnalysis resource = getOhLohRestfulClient().getAnalysisById("maven2", "11371710", new OhLohBaseRequest());
		org.junit.Assert.assertNotNull(resource);
	}
	
	
}
