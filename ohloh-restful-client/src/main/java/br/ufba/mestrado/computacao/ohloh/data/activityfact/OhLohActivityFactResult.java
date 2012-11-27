package br.ufba.mestrado.computacao.ohloh.data.activityfact;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohActivityFactResult {

	
	@XStreamImplicit(itemFieldName="activity_fact")
	private List<OhLohActivityFact> ohLohActivityFacts;
	
	public List<OhLohActivityFact> getOhLohActivityFacts() {
		return ohLohActivityFacts;
	}
	
	public void setOhLohActivityFacts(List<OhLohActivityFact> ohLohActivityFacts) {
		this.ohLohActivityFacts = ohLohActivityFacts;
	}
	
	
}
