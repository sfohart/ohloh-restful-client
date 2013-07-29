package br.ufba.dcc.mestrado.computacao.ohloh.data.enlistment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProject;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(OhLohEnlistment.NODE_NAME)
@Entity
@Table(name = "enlistment")
public class OhLohEnlistment extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -72467167025120985L;

	public final static String NODE_NAME = "enlistment";

	@XStreamAlias("project_id")
	@Column(name = "project_id")
	private Long projectId;

	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OhLohProject ohLohProject;

	@XStreamAlias("repository_id")
	@Column(name = "repository_id")
	private String repositoryId;

	@XStreamAlias("repository")
	@JoinColumn(name = "repository_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OhLohRepository ohLohRepository;

	public OhLohProject getOhLohProject() {
		return ohLohProject;
	}

	public void setOhLohProject(OhLohProject ohLohProject) {
		this.ohLohProject = ohLohProject;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(String repositoryId) {
		this.repositoryId = repositoryId;
	}

	public OhLohRepository getOhLohRepository() {
		return ohLohRepository;
	}

	public void setOhLohRepository(OhLohRepository ohLohRepository) {
		this.ohLohRepository = ohLohRepository;
	}

}
