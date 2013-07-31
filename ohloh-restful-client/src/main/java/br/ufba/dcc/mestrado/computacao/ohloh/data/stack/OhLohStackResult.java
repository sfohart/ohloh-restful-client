package br.ufba.dcc.mestrado.computacao.ohloh.data.stack;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohStackResult {

	
	@XStreamImplicit(itemFieldName="stack")
	private List<OhLohStackDTO> ohLohStackDTOs;
	
	public List<OhLohStackDTO> getOhLohStacks() {
		return ohLohStackDTOs;
	}
	
	public void setOhLohStacks(List<OhLohStackDTO> ohLohStackDTOs) {
		this.ohLohStackDTOs = ohLohStackDTOs;
	}
	
	
}
