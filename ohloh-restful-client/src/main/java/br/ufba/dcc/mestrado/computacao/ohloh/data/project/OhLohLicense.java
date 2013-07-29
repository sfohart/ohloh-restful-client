package br.ufba.dcc.mestrado.computacao.ohloh.data.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(OhLohLicense.NODE_NAME)
@Entity
@Table(name="license")
public class OhLohLicense extends OhLohBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1612821573723959553L;

	public final static String NODE_NAME = "license";
	


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


	
}
