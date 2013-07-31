package br.ufba.dcc.mestrado.computacao.ohloh.entities.contributorfact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;

@Entity
@Table(name=OhLohContributorLanguageFactEntity.NODE_NAME)
public class OhLohContributorLanguageFactEntity extends OhLohBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7975310261186108199L;

	public final static String NODE_NAME = "contributor_language_fact";

	
	@ManyToOne
	@JoinColumn(name="contributor_fact_id", referencedColumnName="id")
	private OhLohContributorFactEntity ohLohContributorFact;

	@Column(name="analysis_id")
	private Long analysisId;

	@Column(name="contributor_id")
	private Long contributorId;

	@Column(name="contributor_name")
	private String contributorName;

	@Column(name="language_id")
	private Long languageId;
	
	@Column(name="language_nice_name")
	private String languageNiceName;

	@Column(name="comment_ratio")
	private Double commentRatio;

	@Column(name="man_months")
	private Integer manMonths;

	@Column(name="commits")
	private Integer commits;

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


	public OhLohContributorFactEntity getOhLohContributorFact() {
		return ohLohContributorFact;
	}

	public void setOhLohContributorFact(OhLohContributorFactEntity ohLohContributorFactEntity) {
		this.ohLohContributorFact = ohLohContributorFactEntity;
	}
	
	

}