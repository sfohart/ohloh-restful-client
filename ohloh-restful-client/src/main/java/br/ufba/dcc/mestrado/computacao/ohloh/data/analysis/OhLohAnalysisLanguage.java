package br.ufba.dcc.mestrado.computacao.ohloh.data.analysis;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;


@XStreamAlias(OhLohAnalysisLanguage.NODE_NAME)
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"content"})
@Entity
@Table(schema="ohloh", name="ohoh_" + OhLohAnalysisLanguage.NODE_NAME)
public class OhLohAnalysisLanguage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1672599783346624942L;

	public final static String NODE_NAME = "language";

	@XStreamAsAttribute
	private Integer percentage;
	
	@XStreamAsAttribute
	private String color;
	
	@XStreamAsAttribute
	@Id
	private Long id;

	
	private String content;

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
