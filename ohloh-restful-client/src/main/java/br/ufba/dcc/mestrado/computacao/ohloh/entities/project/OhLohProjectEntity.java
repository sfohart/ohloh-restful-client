package br.ufba.dcc.mestrado.computacao.ohloh.entities.project;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisEntity;

@Entity
@Table(name = OhLohProjectEntity.NODE_NAME)
public class OhLohProjectEntity extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9128774489845120800L;

	public final static String NODE_NAME = "project";

	@Column(name = "name")
	private String name;

	@Column(name = "url")
	private String url;

	@Column(name = "html_url")
	private String htmlURL;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "description", length=2000)
	private String description;

	@Column(name = "homepage_url")
	private String homepageURL;

	@Column(name = "download_url")
	private String downloadURL;

	@Column(name = "url_name")
	private String urlName;

	@Column(name = "medium_logo_url")
	private String mediumLogoURL;

	@Column(name = "small_logo_url")
	private String smallLogoURL;

	@Column(name = "user_count")
	private Long userCount;

	@Column(name = "average_rating")
	private Double averageRating;

	@Column(name = "rating_count")
	private Long ratingCount;

	@Column(name = "review_count")
	private Long reviewCount;

	@Column(name = "analysis_id")
	private Long analysisId;

	@OneToOne
	@JoinColumn(name = "analysis_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OhLohAnalysisEntity analysis;

	@OneToMany
	private List<OhLohLicenseEntity> ohLohLicenseEntities;

	@OneToMany
	private List<OhLohTagEntity> ohLohTagEntities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtmlURL() {
		return htmlURL;
	}

	public void setHtmlURL(String htmlURL) {
		this.htmlURL = htmlURL;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHomepageURL() {
		return homepageURL;
	}

	public void setHomepageURL(String homepageURL) {
		this.homepageURL = homepageURL;
	}

	public String getDownloadURL() {
		return downloadURL;
	}

	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}

	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

	public String getMediumLogoURL() {
		return mediumLogoURL;
	}

	public void setMediumLogoURL(String mediumLogoURL) {
		this.mediumLogoURL = mediumLogoURL;
	}

	public String getSmallLogoURL() {
		return smallLogoURL;
	}

	public void setSmallLogoURL(String smallLogoURL) {
		this.smallLogoURL = smallLogoURL;
	}

	public Long getUserCount() {
		return userCount;
	}

	public void setUserCount(Long userCount) {
		this.userCount = userCount;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public Long getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(Long ratingCount) {
		this.ratingCount = ratingCount;
	}

	public Long getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(Long analysisId) {
		this.analysisId = analysisId;
	}

	public OhLohAnalysisEntity getAnalysis() {
		return analysis;
	}

	public void setAnalysis(OhLohAnalysisEntity analysis) {
		this.analysis = analysis;
	}

	public List<OhLohLicenseEntity> getOhLohLicenses() {
		return ohLohLicenseEntities;
	}

	public void setOhLohLicenses(List<OhLohLicenseEntity> ohLohLicenseEntities) {
		this.ohLohLicenseEntities = ohLohLicenseEntities;
	}

	public Long getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Long reviewCount) {
		this.reviewCount = reviewCount;
	}

	public List<OhLohTagEntity> getOhLohTags() {
		return ohLohTagEntities;
	}

	public void setOhLohTags(List<OhLohTagEntity> ohLohTagEntities) {
		this.ohLohTagEntities = ohLohTagEntities;
	}

}