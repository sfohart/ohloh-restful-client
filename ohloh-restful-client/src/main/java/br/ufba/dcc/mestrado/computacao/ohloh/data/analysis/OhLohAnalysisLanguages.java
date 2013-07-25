package br.ufba.dcc.mestrado.computacao.ohloh.data.analysis;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("languages")
public class OhLohAnalysisLanguages implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3047964132725598415L;

	@XStreamAlias("graph_url")
	@XStreamAsAttribute
	private String graphURL;
	
	@XStreamImplicit(itemFieldName="language")
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
