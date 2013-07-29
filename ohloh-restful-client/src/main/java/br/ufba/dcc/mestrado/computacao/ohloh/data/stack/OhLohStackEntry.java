package br.ufba.dcc.mestrado.computacao.ohloh.data.stack;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProject;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohStackEntry.NODE_NAME)
@Entity
@Table(name="stack_entry")
public class OhLohStackEntry implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2406930252998297315L;

	public final static String NODE_NAME = "stack_entry";

	@Id
	private Long id;
	
	@XStreamAlias("stack_id")
	@Column(name="stack_id")
	private Long stackId;
	
	@ManyToOne
	@JoinColumn(name="stack_id", referencedColumnName="id", updatable=false, insertable=false)
	private OhLohStack ohLohStack;
	
	@XStreamAlias("project_id")
	@Column(name="project_id")
	private Long projectId;
	
	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("created_at")
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@XStreamAlias("project")
	@ManyToOne
	@JoinColumn(name="project_id", referencedColumnName="id", updatable=false, insertable=false)
	private OhLohProject project;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStackId() {
		return stackId;
	}

	public void setStackId(Long stackId) {
		this.stackId = stackId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public OhLohProject getProject() {
		return project;
	}

	public void setProject(OhLohProject project) {
		this.project = project;
	}
	
	
}
