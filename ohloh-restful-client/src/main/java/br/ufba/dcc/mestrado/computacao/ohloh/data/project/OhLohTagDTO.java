package br.ufba.dcc.mestrado.computacao.ohloh.data.project;

import javax.persistence.Column;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohResultDTO;
import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableLongConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias(OhLohTagDTO.NODE_NAME)
public class OhLohTagDTO implements OhLohResultDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3111939284107189941L;

	public final static String NODE_NAME = "tag";
	
	@XStreamAsAttribute	
	@XStreamConverter(value=NullableLongConverter.class)
	private Long id;

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
