package br.ufba.dcc.mestrado.computacao.ohloh.data.sizefact;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohSizeFactResult {

	
	@XStreamImplicit(itemFieldName="size_fact")
	private List<OhLohSizeFactDTO> ohLohSizeFactDTOs;
	
	public List<OhLohSizeFactDTO> getOhLohSizeFacts() {
		return ohLohSizeFactDTOs;
	}
	
	public void setOhLohSizeFacts(List<OhLohSizeFactDTO> ohLohSizeFactDTOs) {
		this.ohLohSizeFactDTOs = ohLohSizeFactDTOs;
	}
	
	
}
