package br.ufba.dcc.mestrado.computacao.ohloh.data.kudo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohKudoResult {

	
	@XStreamImplicit(itemFieldName="kudo")
	private List<OhLohKudoDTO> ohLohKudoDTOs;
	
	public List<OhLohKudoDTO> getOhLohKudos() {
		return ohLohKudoDTOs;
	}
	
	public void setOhLohKudos(List<OhLohKudoDTO> ohLohKudoDTOs) {
		this.ohLohKudoDTOs = ohLohKudoDTOs;
	}
	
	
}
