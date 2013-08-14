package br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;

@Entity
@Table(name = OhLohAnalysisLanguageEntity.NODE_NAME)
public class OhLohAnalysisLanguageEntity extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1672599783346624942L;

	public final static String NODE_NAME = "language";

	@Column(name = "percentage")
	private String percentage;

	@Column(name = "color")
	private String color;

	@ManyToOne
	@JoinColumn(name = "languages_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OhLohAnalysisLanguagesEntity ohLohAnalysisLanguages;

	@Column(name = "content")
	private String content;

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
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

	public OhLohAnalysisLanguagesEntity getOhLohAnalysisLanguages() {
		return ohLohAnalysisLanguages;
	}

	public void setOhLohAnalysisLanguages(
			OhLohAnalysisLanguagesEntity ohLohAnalysisLanguagesEntity) {
		this.ohLohAnalysisLanguages = ohLohAnalysisLanguagesEntity;
	}

}
