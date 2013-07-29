package br.ufba.dcc.mestrado.computacao.ohloh.data.kudo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProject;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohKudo.NODE_NAME)
@Entity
@Table(name = "kudo")
public class OhLohKudo extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2721389293280846206L;

	public final static String NODE_NAME = "kudo";

	@XStreamConverter(value = ISO8601SqlTimestampConverter.class)
	@XStreamAlias("created_at")
	@Column(name = "created_at")
	private Timestamp createdAt;

	@XStreamAlias("sender_account_id")
	@Column(name = "sender_account_id")
	private String senderAccountId;

	@XStreamAlias("sender_account_name")
	@Column(name = "sender_account_name")
	private String senderAccountName;

	@XStreamAlias("receiver_account_id")
	@Column(name = "receiver_account_id")
	private String receiverAccountId;

	@XStreamAlias("receiver_account_name")
	@Column(name = "receiver_account_name")
	private String receiverAccountName;

	@XStreamAlias("project_id")
	@Column(name = "project_id")
	private Long projectId;

	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OhLohProject ohLohProject;

	@XStreamAlias("project_name")
	@Column(name = "project_name")
	private String projectName;

	@XStreamAlias("contributor_id")
	@Column(name = "contributor_id")
	private String contributorId;

	@XStreamAlias("contributor_name")
	@Column(name = "contributor_name")
	private String contributorName;

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getSenderAccountId() {
		return senderAccountId;
	}

	public void setSenderAccountId(String senderAccountId) {
		this.senderAccountId = senderAccountId;
	}

	public String getSenderAccountName() {
		return senderAccountName;
	}

	public void setSenderAccountName(String senderAccountName) {
		this.senderAccountName = senderAccountName;
	}

	public String getReceiverAccountId() {
		return receiverAccountId;
	}

	public void setReceiverAccountId(String receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
	}

	public String getReceiverAccountName() {
		return receiverAccountName;
	}

	public void setReceiverAccountName(String receiverAccountName) {
		this.receiverAccountName = receiverAccountName;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getContributorId() {
		return contributorId;
	}

	public void setContributorId(String contributorId) {
		this.contributorId = contributorId;
	}

	public String getContributorName() {
		return contributorName;
	}

	public void setContributorName(String contributorName) {
		this.contributorName = contributorName;
	}

	public OhLohProject getOhLohProject() {
		return ohLohProject;
	}

	public void setOhLohProject(OhLohProject ohLohProject) {
		this.ohLohProject = ohLohProject;
	}

}
