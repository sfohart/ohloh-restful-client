package br.ufba.dcc.mestrado.computacao.ohloh.data.analysis;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableLongConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("languages")
@Entity
@Table(name="languages")
public class OhLohAnalysisLanguages implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3047964132725598415L;
	
	@Id
	@GeneratedValue
	@XStreamConverter(value=NullableLongConverter.class)
	private Long id;

	@XStreamAlias("graph_url")
	@XStreamAsAttribute
	@Column(name="graph_url")
	private String graphURL;
	
	@XStreamImplicit(itemFieldName="language")
	@OneToMany(mappedBy="ohLohAnalysisLanguages")
	private List<OhLohAnalysisLanguage> content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
