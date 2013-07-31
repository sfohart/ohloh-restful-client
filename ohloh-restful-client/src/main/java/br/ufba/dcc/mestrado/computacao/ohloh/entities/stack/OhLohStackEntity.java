package br.ufba.dcc.mestrado.computacao.ohloh.entities.stack;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.account.OhLohAccountEntity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@Entity
@Table(name = OhLohStackEntity.NODE_NAME)
public class OhLohStackEntity extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1367617631361506867L;

	public final static String NODE_NAME = "stack";

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "project_count")
	private Integer projectCount;

	@OneToMany(mappedBy = "ohLohStack")
	private List<OhLohStackEntryEntity> ohLohStackEntryEntities;

	@Column(name = "account_id")
	private Long acountId;

	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OhLohAccountEntity account;

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

	public List<OhLohStackEntryEntity> getOhLohStackEntries() {
		return ohLohStackEntryEntities;
	}

	public void setOhLohStackEntries(List<OhLohStackEntryEntity> ohLohStackEntryEntities) {
		this.ohLohStackEntryEntities = ohLohStackEntryEntities;
	}

	public Long getAcountId() {
		return acountId;
	}

	public void setAcountId(Long acountId) {
		this.acountId = acountId;
	}

	public OhLohAccountEntity getAccount() {
		return account;
	}

	public void setAccount(OhLohAccountEntity account) {
		this.account = account;
	}

}
