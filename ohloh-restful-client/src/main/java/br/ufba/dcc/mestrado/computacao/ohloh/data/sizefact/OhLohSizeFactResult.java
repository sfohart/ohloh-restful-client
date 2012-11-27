package br.ufba.dcc.mestrado.computacao.ohloh.data.sizefact;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohSizeFactResult {

	
	@XStreamImplicit(itemFieldName="size_fact")
	private List<OhLohSizeFact> ohLohSizeFacts;
	
	public List<OhLohSizeFact> getOhLohSizeFacts() {
		return ohLohSizeFacts;
	}
	
	public void setOhLohSizeFacts(List<OhLohSizeFact> ohLohSizeFacts) {
		this.ohLohSizeFacts = ohLohSizeFacts;
	}
	
	
}
