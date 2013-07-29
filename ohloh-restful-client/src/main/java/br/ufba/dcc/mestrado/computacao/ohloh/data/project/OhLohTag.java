package br.ufba.dcc.mestrado.computacao.ohloh.data.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(OhLohTag.NODE_NAME)
@Entity
@Table(name = "tag")
public class OhLohTag extends OhLohBaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3111939284107189941L;

	public final static String NODE_NAME = "tag";

	@XStreamAlias("tag")
	@Column(unique = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
