package br.ufba.dcc.mestrado.computacao.ohloh.data.contributorfact;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohContributorFactResult {

	
	@XStreamImplicit(itemFieldName="contributor_fact")
	private List<OhLohContributorFactDTO> ohLohContributorFactDTOs;
	
	public List<OhLohContributorFactDTO> getOhLohContributorFacts() {
		return ohLohContributorFactDTOs;
	}
	
	public void setOhLohContributorFacts(
			List<OhLohContributorFactDTO> ohLohContributorFactDTOs) {
		this.ohLohContributorFactDTOs = ohLohContributorFactDTOs;
	}
	
}
