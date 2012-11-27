package br.ufba.mestrado.computacao.ohloh.data.contributorfact;

import br.ufba.mestrado.computacao.xstream.converters.NullableDoubleConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("contributor_language_fact")
public class OhLohContributorLanguageFact {

	@XStreamAlias("analysis_id")
	private String analysisId;

	@XStreamAlias("contributor_id")
	private String contributorId;

	@XStreamAlias("contributor_name")
	private String contributorName;

	@XStreamAlias("language_id")
	private String languageId;
	
	@XStreamAlias("language_nice_name")
	private String languageNiceName;

	@XStreamAlias("comment_ratio")
	@XStreamConverter(value = NullableDoubleConverter.class)
	private Double commentRatio;

	@XStreamAlias("man_months")
	private Integer manMonths;

	private Integer commits;

	@XStreamConverter(value = NullableDoubleConverter.class)
	@XStreamAlias("median_commits")
	private Double medianCommits;

	public String getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(String analysisId) {
		this.analysisId = analysisId;
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

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	
	public String getLanguageNiceName() {
		return languageNiceName;
	}
	
	public void setLanguageNiceName(String languageNiceName) {
		this.languageNiceName = languageNiceName;
	}

	public Double getCommentRatio() {
		return commentRatio;
	}

	public void setCommentRatio(Double commentRatio) {
		this.commentRatio = commentRatio;
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
	
	

}
