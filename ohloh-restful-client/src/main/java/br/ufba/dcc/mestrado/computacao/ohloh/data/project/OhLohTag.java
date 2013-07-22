package br.ufba.dcc.mestrado.computacao.ohloh.data.project;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(OhLohTag.NODE_NAME)
public class OhLohTag {
	public final static String NODE_NAME = "tag";
	
	
	@XStreamAlias("tag")
	private String name;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

}
