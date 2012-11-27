package br.ufba.mestrado.computacao.ohloh.data.contributorfact;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohContributorFactResult {

	
	@XStreamImplicit(itemFieldName="contributor_fact")
	private List<OhLohContributorFact> ohLohContributorFacts;
	
	public List<OhLohContributorFact> getOhLohContributorFacts() {
		return ohLohContributorFacts;
	}
	
	public void setOhLohContributorFacts(
			List<OhLohContributorFact> ohLohContributorFacts) {
		this.ohLohContributorFacts = ohLohContributorFacts;
	}
	
}
