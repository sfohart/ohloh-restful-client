package br.ufba.dcc.mestrado.computacao.ohloh.data.analysis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;


@XStreamAlias(OhLohAnalysisLanguage.NODE_NAME)
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"content"})
@Entity
@Table(name="language")
public class OhLohAnalysisLanguage extends OhLohBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1672599783346624942L;

	public final static String NODE_NAME = "language";

	@XStreamAsAttribute
	@Column(name="percentage")
	private Integer percentage;
	
	@XStreamAsAttribute
	@Column(name="color")
	private String color;

	@ManyToOne
	@JoinColumn(name="languages_id", referencedColumnName="id", insertable=false, updatable=false)
	private OhLohAnalysisLanguages ohLohAnalysisLanguages;

	@Column(name="content")
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public OhLohAnalysisLanguages getOhLohAnalysisLanguages() {
		return ohLohAnalysisLanguages;
	}

	public void setOhLohAnalysisLanguages(
			OhLohAnalysisLanguages ohLohAnalysisLanguages) {
		this.ohLohAnalysisLanguages = ohLohAnalysisLanguages;
	}
	
	
	
}
