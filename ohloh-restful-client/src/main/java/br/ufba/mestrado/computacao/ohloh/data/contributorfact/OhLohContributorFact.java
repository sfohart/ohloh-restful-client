package br.ufba.mestrado.computacao.ohloh.data.contributorfact;


import java.sql.Timestamp;
import java.util.List;

import br.ufba.mestrado.computacao.xstream.converters.NullableDoubleConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias("contributor_fact")
public class OhLohContributorFact {

	@XStreamAlias("contributor_id")
	private String id;
	
	@XStreamAlias("account_id")
	private String accountId;
	
	@XStreamAlias("account_name")
	private String accountName;
	
	@XStreamAlias("analysis_id")
	private String analysisId;
	
	@XStreamAlias("contributor_name")
	private String contributorName;
	
	@XStreamAlias("primary_language_id")
	private String primaryLanguageId;
	
	@XStreamAlias("primary_language_nice_name")
	private String primaryLanguageNiceName;
	
	@XStreamAlias("comment_ratio")
	@XStreamConverter(value=NullableDoubleConverter.class)
	private Double commentRatio;
	
	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("first_commit_time")
	private Timestamp firstCommitTime;
	
	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("last_commit_time")
	private Timestamp lastCommitTime;
	
	@XStreamAlias("man_months")
	private Integer manMonths;
	
	private Integer commits;
	
	@XStreamConverter(value=NullableDoubleConverter.class)
	@XStreamAlias("median_commits")
	private Double medianCommits;
	
	@XStreamAlias("contributor_language_facts")
	private List<OhLohContributorLanguageFact> ohLohContributorLanguageFacts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(String analysisId) {
		this.analysisId = analysisId;
	}

	public String getContributorName() {
		return contributorName;
	}

	public void setContributorName(String contributorName) {
		this.contributorName = contributorName;
	}

	public String getPrimaryLanguageId() {
		return primaryLanguageId;
	}

	public void setPrimaryLanguageId(String primaryLanguageId) {
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
