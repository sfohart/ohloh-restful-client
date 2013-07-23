package br.ufba.dcc.mestrado.computacao.ohloh.data.enlistment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(OhLohEnlistment.NODE_NAME)
@Entity
@Table(name="ohoh_" + OhLohEnlistment.NODE_NAME)
public class OhLohEnlistment {
	
	public final static String NODE_NAME = "enlistment";

	@Id
	private String id;
	
	@XStreamAlias("project_id")
	private String projectId;
	
	@XStreamAlias("repository_id")
	private String repositoryId;
	
	@XStreamAlias("repository")
	private OhLohRepository ohLohRepository;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
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
