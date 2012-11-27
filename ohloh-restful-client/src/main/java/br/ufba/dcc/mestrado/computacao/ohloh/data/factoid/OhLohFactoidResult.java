package br.ufba.dcc.mestrado.computacao.ohloh.data.factoid;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohFactoidResult {
	
	@XStreamImplicit(itemFieldName="factoid")
	private List<OhLohFactoid> ohLohFactoids;
	
	public List<OhLohFactoid> getOhLohFactoids() {
		return ohLohFactoids;
	}
	
	public void setOhLohFactoids(List<OhLohFactoid> ohLohFactoids) {
		this.ohLohFactoids = ohLohFactoids;
	}
	
}
