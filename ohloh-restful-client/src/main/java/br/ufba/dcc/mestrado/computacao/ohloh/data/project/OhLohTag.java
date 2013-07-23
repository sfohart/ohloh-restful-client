package br.ufba.dcc.mestrado.computacao.ohloh.data.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(OhLohTag.NODE_NAME)
@Entity
@Table(name="ohoh_tag")
public class OhLohTag {
	public final static String NODE_NAME = "tag";

	@XStreamAlias("tag")
	@Column(unique=true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
