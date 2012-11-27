package br.ufba.dcc.mestrado.computacao.ohloh.data.analysis;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("result")
public class OhLohAnalysisResult {

	private OhLohAnalysis analysis;
	
	public OhLohAnalysis getAnalysis() {
		return analysis;
	}
	
	public void setAnalysis(OhLohAnalysis analysis) {
		this.analysis = analysis;
	}
	
}
