package br.ufba.dcc.mestrado.computacao.ohloh.data.contributorfact;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableDoubleConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohContributorFact.NODE_NAME)
@Entity
@Table(name="contributor_fact")
public class OhLohContributorFact extends OhLohBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6755139715374660722L;

	public final static String NODE_NAME = "contributor_fact";

	
	@XStreamAlias("contributor_id")
	private Long contributorId;
	
	@XStreamAlias("account_id")
	@Column(name="account_id")
	private Long accountId;
	
	@XStreamAlias("account_name")
	@Column(name="account_name")
	private String accountName;
	
	@XStreamAlias("analysis_id")
	@Column(name="analysis_id")
	private Long analysisId;
	
	@XStreamAlias("contributor_name")
	@Column(name="contributor_name")
	private String contributorName;
	
	@XStreamAlias("primary_language_id")
	@Column(name="primary_language_id")
	private Long primaryLanguageId;
	
	@XStreamAlias("primary_language_nice_name")
	@Column(name="primary_language_nice_name")
	private String primaryLanguageNiceName;
	
	@XStreamAlias("comment_ratio")
	@Column(name="comment_ratio")
	@XStreamConverter(value=NullableDoubleConverter.class)
	private Double commentRatio;
	
	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("first_commit_time")
	@Column(name="first_commit_time")
	private Timestamp firstCommitTime;
	
	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("last_commit_time")
	@Column(name="last_commit_time")
	private Timestamp lastCommitTime;
	
	@XStreamAlias("man_months")
	@Column(name="man_months")
	private Integer manMonths;
	
	@Column(name="commits")
	private Integer commits;
	
	@XStreamConverter(value=NullableDoubleConverter.class)
	@XStreamAlias("median_commits")
	@Column(name="median_commits")
	private Double medianCommits;
	
	@XStreamAlias("contributor_language_facts")
	@OneToMany(mappedBy="ohLohContributorFact")
	private List<OhLohContributorLanguageFact> ohLohContributorLanguageFacts;

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
	
	public List<OhLohContributorLanguageFact> getOhLohContributorLanguageFacts() {
		return ohLohContributorLanguageFacts;
	}
	
	public void setOhLohContributorLanguageFacts(
			List<OhLohContributorLanguageFact> ohLohContributorLanguageFacts) {
		this.ohLohContributorLanguageFacts = ohLohContributorLanguageFacts;
	}
}
