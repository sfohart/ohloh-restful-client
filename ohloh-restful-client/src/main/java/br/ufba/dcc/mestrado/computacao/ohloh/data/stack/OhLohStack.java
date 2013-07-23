package br.ufba.dcc.mestrado.computacao.ohloh.data.stack;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.account.OhLohAccount;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohStack.NODE_NAME)
@Entity
@Table(name="ohoh_" + OhLohStack.NODE_NAME)
public class OhLohStack {
	
	public final static String NODE_NAME = "stack";

	@Id
	private String id;
	
	private String title;
	private String description;
	
	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("updated_at")
	private Timestamp updatedAt;
	
	@XStreamAlias("project_count")
	private Integer projectCount;
	
	@XStreamAlias("stack_entries")
	private List<OhLohStackEntry> ohLohStackEntries;
	
	@XStreamAlias("account_id")
	private String acountId;
	
	private OhLohAccount account;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getAcountId() {
		return acountId;
	}

	public void setAcountId(String acountId) {
		this.acountId = acountId;
	}

	public OhLohAccount getAccount() {
		return account;
	}

	public void setAccount(OhLohAccount account) {
		this.account = account;
	}
	
	
	
}
