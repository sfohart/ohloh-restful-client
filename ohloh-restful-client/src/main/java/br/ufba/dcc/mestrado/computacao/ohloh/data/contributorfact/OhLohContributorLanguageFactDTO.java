package br.ufba.dcc.mestrado.computacao.ohloh.data.contributorfact;

import java.io.Serializable;

import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableDoubleConverter;
import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableLongConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias(OhLohContributorLanguageFactDTO.NODE_NAME)
public class OhLohContributorLanguageFactDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7975310261186108199L;

	public final static String NODE_NAME = "contributor_language_fact";

	@XStreamAsAttribute	
	@XStreamConverter(value=NullableLongConverter.class)
	private Long id;

	@XStreamAlias("analysis_id")
	private Long analysisId;

	@XStreamAlias("contributor_id")
	private Long contributorId;

	@XStreamAlias("contributor_name")
	private String contributorName;

	@XStreamAlias("language_id")
	private Long languageId;

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

	public Long getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(Long analysisId) {
		this.analysisId = analysisId;
	}

	public Long getContributorId() {
		return contributorId;
	}

	public void setContributorId(Long contributorId) {
		this.contributorId = contributorId;
	}

	public String getContributorName() {
		return contributorName;
	}

	public void setContributorName(String contributorName) {
		this.contributorName = contributorName;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
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