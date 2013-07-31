package br.ufba.dcc.mestrado.computacao.ohloh.data.factoid;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohFactoidResult {
	
	@XStreamImplicit(itemFieldName="factoid")
	private List<OhLohFactoidDTO> ohLohFactoidDTOs;
	
	public List<OhLohFactoidDTO> getOhLohFactoids() {
		return ohLohFactoidDTOs;
	}
	
	public void setOhLohFactoids(List<OhLohFactoidDTO> ohLohFactoidDTOs) {
		this.ohLohFactoidDTOs = ohLohFactoidDTOs;
	}
	
}
