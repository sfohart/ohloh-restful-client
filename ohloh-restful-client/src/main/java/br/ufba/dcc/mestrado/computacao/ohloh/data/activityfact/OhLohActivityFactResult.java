package br.ufba.dcc.mestrado.computacao.ohloh.data.activityfact;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohActivityFactResult {

	
	@XStreamImplicit(itemFieldName="activity_fact")
	private List<OhLohActivityFactDTO> ohLohActivityFactDTOs;
	
	public List<OhLohActivityFactDTO> getOhLohActivityFacts() {
		return ohLohActivityFactDTOs;
	}
	
	public void setOhLohActivityFacts(List<OhLohActivityFactDTO> ohLohActivityFactDTOs) {
		this.ohLohActivityFactDTOs = ohLohActivityFactDTOs;
	}
	
	
}
