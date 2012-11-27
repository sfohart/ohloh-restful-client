package br.ufba.mestrado.computacao.ohloh.data.kudo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohKudoResult {

	
	@XStreamImplicit(itemFieldName="kudo")
	private List<OhLohKudo> ohLohKudos;
	
	public List<OhLohKudo> getOhLohKudos() {
		return ohLohKudos;
	}
	
	public void setOhLohKudos(List<OhLohKudo> ohLohKudos) {
		this.ohLohKudos = ohLohKudos;
	}
	
	
}
