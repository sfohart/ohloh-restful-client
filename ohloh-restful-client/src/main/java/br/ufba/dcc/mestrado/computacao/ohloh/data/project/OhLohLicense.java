package br.ufba.dcc.mestrado.computacao.ohloh.data.project;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(OhLohLicense.NODE_NAME)
@Entity
@Table(schema="ohloh", name="ohloh_" + OhLohLicense.NODE_NAME)
public class OhLohLicense implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1612821573723959553L;

	public final static String NODE_NAME = "license";
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique=true)
	private String name;
	
	@XStreamAlias("nice_name")	
	private String niceName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNiceName() {
		return niceName;
	}

	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
