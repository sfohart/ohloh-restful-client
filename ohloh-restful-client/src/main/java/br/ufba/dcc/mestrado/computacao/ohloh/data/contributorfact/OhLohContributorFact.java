package br.ufba.dcc.mestrado.computacao.ohloh.data.contributorfact;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableDoubleConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohContributorFact.NODE_NAME)
@Entity
@Table(name="contributor_fact")
public class OhLohContributorFact implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6755139715374660722L;

	public final static String NODE_NAME = "contributor_fact";

	@XStreamAlias("contributor_id")
	@Id
	private Long id;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
