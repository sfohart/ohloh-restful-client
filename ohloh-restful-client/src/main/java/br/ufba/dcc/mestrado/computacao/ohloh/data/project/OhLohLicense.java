package br.ufba.dcc.mestrado.computacao.ohloh.data.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("license")
@Entity
@Table(name="ohloh_license")
public class OhLohLicense {

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
