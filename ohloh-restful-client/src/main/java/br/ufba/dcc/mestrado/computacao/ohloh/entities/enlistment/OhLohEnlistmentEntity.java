package br.ufba.dcc.mestrado.computacao.ohloh.entities.enlistment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;

@Entity
@Table(name = OhLohEnlistmentEntity.NODE_NAME)
public class OhLohEnlistmentEntity extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -72467167025120985L;

	public final static String NODE_NAME = "enlistment";

	@Column(name = "project_id")
	private Long projectId;

	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OhLohProjectEntity ohLohProjectEntity;

	@Column(name = "repository_id")
	private Long repositoryId;

	@JoinColumn(name = "repository_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OhLohRepositoryEntity ohLohRepository;

	public OhLohProjectEntity getOhLohProject() {
		return ohLohProjectEntity;
	}

	public void setOhLohProject(OhLohProjectEntity ohLohProjectEntity) {
		this.ohLohProjectEntity = ohLohProjectEntity;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(Long repositoryId) {
		this.repositoryId = repositoryId;
	}

	public OhLohRepositoryEntity getOhLohRepository() {
		return ohLohRepository;
	}

	public void setOhLohRepository(OhLohRepositoryEntity ohLohRepositoryEntity) {
		this.ohLohRepository = ohLohRepositoryEntity;
	}

}
