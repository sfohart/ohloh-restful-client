package br.ufba.dcc.mestrado.computacao.ohloh.data.factoid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysis;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias(OhLohFactoid.NODE_NAME)
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"description"})
@Entity
@Table(name="factoid")
public class OhLohFactoid  extends OhLohBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2218492589477862288L;

	public final static String NODE_NAME = "factoid";

	@XStreamAsAttribute
	@Column(name="type")
	private String type;
	
	@XStreamAlias("analysis_id")
	@Column(name="analysis_id")
	private Long analysisId;
	
	@ManyToOne
	@JoinColumn(name="analysis_id", referencedColumnName="id", updatable=false, insertable=false)
	private OhLohAnalysis ohLohAnalysis;

	
	@Column(name="severity")
	private Integer severity;
	
	@Column(name="description")
	private String description;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	public Long getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(Long analysisId) {
		this.analysisId = analysisId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public OhLohAnalysis getOhLohAnalysis() {
		return ohLohAnalysis;
	}

	public void setOhLohAnalysis(OhLohAnalysis ohLohAnalysis) {
		this.ohLohAnalysis = ohLohAnalysis;
	}
	
}
