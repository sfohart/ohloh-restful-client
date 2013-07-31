package br.ufba.dcc.mestrado.computacao.ohloh.entities.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;

@Entity
@Table(name = OhLohTagEntity.NODE_NAME)
public class OhLohTagEntity extends OhLohBaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3111939284107189941L;

	public final static String NODE_NAME = "tag";

	@Column(unique = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
