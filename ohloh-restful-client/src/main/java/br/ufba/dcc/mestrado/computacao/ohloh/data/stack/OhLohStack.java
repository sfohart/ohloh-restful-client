package br.ufba.dcc.mestrado.computacao.ohloh.data.stack;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.data.account.OhLohAccount;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohStack.NODE_NAME)
@Entity
@Table(name = "stack")
public class OhLohStack extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1367617631361506867L;

	public final static String NODE_NAME = "stack";

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@XStreamConverter(value = ISO8601SqlTimestampConverter.class)
	@XStreamAlias("updated_at")
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@XStreamAlias("project_count")
	@Column(name = "project_count")
	private Integer projectCount;

	@XStreamAlias("stack_entries")
	@OneToMany(mappedBy = "ohLohStack")
	private List<OhLohStackEntry> ohLohStackEntries;

	@XStreamAlias("account_id")
	@Column(name = "account_id")
	private Long acountId;

	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OhLohAccount account;

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

	public List<OhLohStackEntry> getOhLohStackEntries() {
		return ohLohStackEntries;
	}

	public void setOhLohStackEntries(List<OhLohStackEntry> ohLohStackEntries) {
		this.ohLohStackEntries = ohLohStackEntries;
	}

	public Long getAcountId() {
		return acountId;
	}

	public void setAcountId(Long acountId) {
		this.acountId = acountId;
	}

	public OhLohAccount getAccount() {
		return account;
	}

	public void setAccount(OhLohAccount account) {
		this.account = account;
	}

}
