package br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;

@Entity
@Table(name=OhLohAnalysisLanguagesEntity.NODE_NAME)
public class OhLohAnalysisLanguagesEntity extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3047964132725598415L;
	
	public final static String NODE_NAME = "languages";

	@Column(name="graph_url")
	private String graphURL;
	
	@OneToMany(mappedBy="ohLohAnalysisLanguages")
	private List<OhLohAnalysisLanguageEntity> content;

	public String getGraphURL() {
		return graphURL;
	}

	public void setGraphURL(String graphURL) {
		this.graphURL = graphURL;
	}

	public List<OhLohAnalysisLanguageEntity> getContent() {
		return content;
	}

	public void setContent(List<OhLohAnalysisLanguageEntity> content) {
		this.content = content;
	}
	
	
}
