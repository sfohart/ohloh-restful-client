package br.ufba.mestrado.computacao.ohloh.restful.responses;

import br.ufba.mestrado.computacao.ohloh.data.activityfact.OhLohActivityFactResult;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(OhLohActivityFactResponse.NODE_NAME)
public class OhLohActivityFactResponse extends OhLohBaseResponse {

	private OhLohActivityFactResult result;
	
	public OhLohActivityFactResult getResult() {
		return result;
	}
	
	public void setResult(OhLohActivityFactResult result) {
		this.result = result;
	}
	
}
