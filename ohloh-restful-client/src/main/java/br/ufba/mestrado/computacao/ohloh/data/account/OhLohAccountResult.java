package br.ufba.mestrado.computacao.ohloh.data.account;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class OhLohAccountResult {
	
	@XStreamImplicit(itemFieldName="account")
	private List<OhLohAccount> ohLohAccounts;
	
	public List<OhLohAccount> getOhLohAccounts() {
		return ohLohAccounts;
	}
	
	public void setOhLohAccounts(List<OhLohAccount> ohLohAccounts) {
		this.ohLohAccounts = ohLohAccounts;
	}
	
	
}
