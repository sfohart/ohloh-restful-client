package br.ufba.dcc.mestrado.computacao.ohloh.data.enlistment;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohResultDTO;
import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableLongConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias(OhLohEnlistmentDTO.NODE_NAME)
public class OhLohEnlistmentDTO implements OhLohResultDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -72467167025120985L;

	public final static String NODE_NAME = "enlistment";

	@XStreamAsAttribute	
	@XStreamConverter(value=NullableLongConverter.class)
	private Long id;
	
	@XStreamAlias("project_id")
	private Long projectId;

	@XStreamAlias("repository_id")
	private String repositoryId;

	@XStreamAlias("repository")
	private OhLohRepositoryDTO ohLohRepositoryDTO;

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

	public OhLohRepositoryDTO getOhLohRepository() {
		return ohLohRepositoryDTO;
	}

	public void setOhLohRepository(OhLohRepositoryDTO ohLohRepositoryDTO) {
		this.ohLohRepositoryDTO = ohLohRepositoryDTO;
	}

}
