package br.ufba.dcc.mestrado.computacao.ohloh.data.stack;

import java.io.Serializable;
import java.sql.Timestamp;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectDTO;
import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableLongConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohStackEntryDTO.NODE_NAME)
public class OhLohStackEntryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2406930252998297315L;

	public final static String NODE_NAME = "stack_entry";
	
	@XStreamAsAttribute	
	@XStreamConverter(value=NullableLongConverter.class)
	private Long id;

	@XStreamAlias("stack_id")
	private Long stackId;


	@XStreamAlias("project_id")
	private Long projectId;

	@XStreamConverter(value = ISO8601SqlTimestampConverter.class)
	@XStreamAlias("created_at")
	private Timestamp createdAt;

	@XStreamAlias("project")
	private OhLohProjectDTO project;

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

	public OhLohProjectDTO getProject() {
		return project;
	}

	public void setProject(OhLohProjectDTO project) {
		this.project = project;
	}

}
