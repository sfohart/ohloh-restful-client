package br.ufba.dcc.mestrado.computacao.ohloh.data.stack;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProject;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias("stack_entry")
@Entity
@Table(name="ohoh_stack_entry")
public class OhLohStackEntry {

	@Id
	private String id;
	
	@XStreamAlias("stack_id")
	private String stackId;
	
	@XStreamAlias("project_id")
	private String projectId;
	
	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("created_at")
	private Timestamp createdAt;
	
	@XStreamAlias("project")
	private OhLohProject project;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStackId() {
		return stackId;
	}

	public void setStackId(String stackId) {
		this.stackId = stackId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
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
