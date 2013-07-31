package br.ufba.dcc.mestrado.computacao.ohloh.entities.stack;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;

@Entity
@Table(name = OhLohStackEntryEntity.NODE_NAME)
public class OhLohStackEntryEntity extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2406930252998297315L;

	public final static String NODE_NAME = "stack_entry";

	@Column(name = "stack_id")
	private Long stackId;

	@ManyToOne
	@JoinColumn(name = "stack_id", referencedColumnName = "id", updatable = false, insertable = false)
	private OhLohStackEntity ohLohStack;

	@Column(name = "project_id")
	private Long projectId;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "id", updatable = false, insertable = false)
	private OhLohProjectEntity project;

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

	public OhLohProjectEntity getProject() {
		return project;
	}

	public void setProject(OhLohProjectEntity project) {
		this.project = project;
	}

}
