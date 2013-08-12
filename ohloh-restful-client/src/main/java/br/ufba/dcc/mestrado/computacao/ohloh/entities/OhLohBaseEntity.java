package br.ufba.dcc.mestrado.computacao.ohloh.entities;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableLongXStreamConverter;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class OhLohBaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1172528122380283680L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	
	
}
