package br.ufba.mestrado.computacao.ohloh.data.enlistment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("enlistment")
public class OhLohEnlistment {

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
