package br.ufba.dcc.mestrado.computacao.ohloh.data.analysis;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("languages")
@Entity
@Table(name="languages")
public class OhLohAnalysisLanguages extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3047964132725598415L;

	@XStreamAlias("graph_url")
	@XStreamAsAttribute
	@Column(name="graph_url")
	private String graphURL;
	
	@XStreamImplicit(itemFieldName="language")
	@OneToMany(mappedBy="ohLohAnalysisLanguages")
	private List<OhLohAnalysisLanguage> content;

	public String getGraphURL() {
		return graphURL;
	}

	public void setGraphURL(String graphURL) {
		this.graphURL = graphURL;
	}

	public List<OhLohAnalysisLanguage> getContent() {
		return content;
	}

	public void setContent(List<OhLohAnalysisLanguage> content) {
		this.content = content;
	}
	
	
}
