package br.ufba.dcc.mestrado.computacao.ohloh.data.stack;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableLongConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohStackDTO.NODE_NAME)
public class OhLohStackDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1367617631361506867L;

	public final static String NODE_NAME = "stack";
	
	@XStreamAsAttribute	
	@XStreamConverter(value=NullableLongConverter.class)
	private Long id;

	private String title;

	private String description;

	@XStreamConverter(value = ISO8601SqlTimestampConverter.class)
	@XStreamAlias("updated_at")
	private Timestamp updatedAt;

	@XStreamAlias("project_count")
	private Integer projectCount;

	@XStreamAlias("stack_entries")
	private List<OhLohStackEntryDTO> ohLohStackEntryDTOs;

	@XStreamAlias("account_id")
	private Long acountId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(Integer projectCount) {
		this.projectCount = projectCount;
	}

	public List<OhLohStackEntryDTO> getOhLohStackEntries() {
		return ohLohStackEntryDTOs;
	}

	public void setOhLohStackEntries(List<OhLohStackEntryDTO> ohLohStackEntryDTOs) {
		this.ohLohStackEntryDTOs = ohLohStackEntryDTOs;
	}

	public Long getAcountId() {
		return acountId;
	}

	public void setAcountId(Long acountId) {
		this.acountId = acountId;
	}


}
