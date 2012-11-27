package br.ufba.mestrado.computacao.ohloh.data.enlistment;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohEnlistmentResult {
	
	@XStreamImplicit(itemFieldName="enlistment")
	private List<OhLohEnlistment> ohLohEnlistments;
	
	public List<OhLohEnlistment> getOhLohEnlistments() {
		return ohLohEnlistments;
	}
	
	public void setOhLohEnlistments(List<OhLohEnlistment> ohLohEnlistments) {
		this.ohLohEnlistments = ohLohEnlistments;
	}
	
	
}
