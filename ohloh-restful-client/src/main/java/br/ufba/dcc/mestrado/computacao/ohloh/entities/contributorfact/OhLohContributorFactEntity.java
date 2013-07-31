package br.ufba.dcc.mestrado.computacao.ohloh.entities.contributorfact;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;

@Entity
@Table(name=OhLohContributorFactEntity.NODE_NAME)
public class OhLohContributorFactEntity extends OhLohBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6755139715374660722L;

	public final static String NODE_NAME = "contributor_fact";

	
	@Column(name="contributor_id")
	private Long contributorId;
	
	@Column(name="account_id")
	private Long accountId;
	
	@Column(name="account_name")
	private String accountName;
	
	@Column(name="analysis_id")
	private Long analysisId;
	
	@Column(name="contributor_name")
	private String contributorName;
	
	@Column(name="primary_language_id")
	private Long primaryLanguageId;
	
	@Column(name="primary_language_nice_name")
	private String primaryLanguageNiceName;
	
	@Column(name="comment_ratio")
	private Double commentRatio;
	
	@Column(name="first_commit_time")
	private Timestamp firstCommitTime;
	
	@Column(name="last_commit_time")
	private Timestamp lastCommitTime;
	
	@Column(name="man_months")
	private Integer manMonths;
	
	@Column(name="commits")
	private Integer commits;
	
	@Column(name="median_commits")
	private Double medianCommits;
	
	@OneToMany(mappedBy="ohLohContributorFact")
	private List<OhLohContributorLanguageFactEntity> ohLohContributorLanguageFacts;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Long getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(Long analysisId) {
		this.analysisId = analysisId;
	}

	public String getContributorName() {
		return contributorName;
	}

	public void setContributorName(String contributorName) {
		this.contributorName = contributorName;
	}

	public Long getPrimaryLanguageId() {
		return primaryLanguageId;
	}

	public void setPrimaryLanguageId(Long primaryLanguageId) {
		this.primaryLanguageId = primaryLanguageId;
	}

	public String getPrimaryLanguageNiceName() {
		return primaryLanguageNiceName;
	}

	public void setPrimaryLanguageNiceName(String primaryLanguageNiceName) {
		this.primaryLanguageNiceName = primaryLanguageNiceName;
	}

	public Double getCommentRatio() {
		return commentRatio;
	}

	public void setCommentRatio(Double commentRatio) {
		this.commentRatio = commentRatio;
	}

	public Timestamp getFirstCommitTime() {
		return firstCommitTime;
	}

	public void setFirstCommitTime(Timestamp firstCommitTime) {
		this.firstCommitTime = firstCommitTime;
	}

	public Timestamp getLastCommitTime() {
		return lastCommitTime;
	}

	public void setLastCommitTime(Timestamp lastCommitTime) {
		this.lastCommitTime = lastCommitTime;
	}

	public Integer getManMonths() {
		return manMonths;
	}

	public void setManMonths(Integer manMonths) {
		this.manMonths = manMonths;
	}

	public Integer getCommits() {
		return commits;
	}

	public void setCommits(Integer commits) {
		this.commits = commits;
	}

	public Double getMedianCommits() {
		return medianCommits;
	}

	public void setMedianCommits(Double medianCommits) {
		this.medianCommits = medianCommits;
	}
	
	public List<OhLohContributorLanguageFactEntity> getOhLohContributorLanguageFacts() {
		return ohLohContributorLanguageFacts;
	}
	
	public void setOhLohContributorLanguageFacts(
			List<OhLohContributorLanguageFactEntity> ohLohContributorLanguageFacts) {
		this.ohLohContributorLanguageFacts = ohLohContributorLanguageFacts;
	}
}
