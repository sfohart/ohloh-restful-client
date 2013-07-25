package br.ufba.dcc.mestrado.computacao.ohloh.data.factoid;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias(OhLohFactoid.NODE_NAME)
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"description"})
@Entity
@Table(schema="ohloh", name="ohoh_" + OhLohFactoid.NODE_NAME)
public class OhLohFactoid  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2218492589477862288L;

	public final static String NODE_NAME = "factoid";

	@XStreamAsAttribute
	private String type;
	
	@XStreamAlias("analysis_id")
	private String analysisId;
	
	@Id
	private Integer id;
	
	private Integer severity;
	
	private String description;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	public String getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(String analysisId) {
		this.analysisId = analysisId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
