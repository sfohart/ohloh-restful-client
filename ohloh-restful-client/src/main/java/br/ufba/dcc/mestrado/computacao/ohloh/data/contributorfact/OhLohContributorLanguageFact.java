package br.ufba.dcc.mestrado.computacao.ohloh.data.contributorfact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableDoubleConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias(OhLohContributorLanguageFact.NODE_NAME)
@Entity
@Table(name="contributor_language_fact")
public class OhLohContributorLanguageFact extends OhLohBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7975310261186108199L;

	public final static String NODE_NAME = "contributor_language_fact";

	
	@ManyToOne
	@JoinColumn(name="contributor_fact_id", referencedColumnName="id")
	private OhLohContributorFact ohLohContributorFact;

	@XStreamAlias("analysis_id")
	@Column(name="analysis_id")
	private Long analysisId;

	@XStreamAlias("contributor_id")
	@Column(name="contributor_id")
	private Long contributorId;

	@XStreamAlias("contributor_name")
	@Column(name="contributor_name")
	private String contributorName;

	@XStreamAlias("language_id")
	@Column(name="language_id")
	private Long languageId;
	
	@XStreamAlias("language_nice_name")
	@Column(name="language_nice_name")
	private String languageNiceName;

	@XStreamAlias("comment_ratio")
	@XStreamConverter(value = NullableDoubleConverter.class)
	@Column(name="comment_ratio")
	private Double commentRatio;

	@XStreamAlias("man_months")
	@Column(name="man_months")
	private Integer manMonths;

	@Column(name="commits")
	private Integer commits;

	@XStreamConverter(value = NullableDoubleConverter.class)
	@XStreamAlias("median_commits")
	@Column(name="median_commits")
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


	public OhLohContributorFact getOhLohContributorFact() {
		return ohLohContributorFact;
	}

	public void setOhLohContributorFact(OhLohContributorFact ohLohContributorFact) {
		this.ohLohContributorFact = ohLohContributorFact;
	}
	
	

}
