package br.ufba.dcc.mestrado.computacao.ohloh.entities;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class OhLohBaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1172528122380283680L;
	
	private Long id;

	@Access(AccessType.PROPERTY)
	@Id
	@Column(name="id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
