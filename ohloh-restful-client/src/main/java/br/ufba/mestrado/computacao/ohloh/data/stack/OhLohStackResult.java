package br.ufba.mestrado.computacao.ohloh.data.stack;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohStackResult {

	
	@XStreamImplicit(itemFieldName="stack")
	private List<OhLohStack> ohLohStacks;
	
	public List<OhLohStack> getOhLohStacks() {
		return ohLohStacks;
	}
	
	public void setOhLohStacks(List<OhLohStack> ohLohStacks) {
		this.ohLohStacks = ohLohStacks;
	}
	
	
}
