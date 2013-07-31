package br.ufba.dcc.mestrado.computacao.ohloh.data.project;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysis;
import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableDoubleConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohProject.NODE_NAME)
@Entity
@Table(name = "project")
public class OhLohProject extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9128774489845120800L;

	public final static String NODE_NAME = "project";

	@Column(name = "name")
	private String name;

	@Column(name = "url")
	private String url;

	@XStreamAlias("html_url")
	@Column(name = "html_url")
	private String htmlURL;

	@XStreamConverter(value = ISO8601SqlTimestampConverter.class)
	@XStreamAlias("created_at")
	@Column(name = "created_at")
	private Timestamp createdAt;

	@XStreamConverter(value = ISO8601SqlTimestampConverter.class)
	@XStreamAlias("updated_at")
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "description")
	private String description;

	@XStreamAlias("homepage_url")
	@Column(name = "homepage_url")
	private String homepageURL;

	@XStreamAlias("download_url")
	@Column(name = "download_url")
	private String downloadURL;

	@XStreamAlias("url_name")
	@Column(name = "url_name")
	private String urlName;

	@XStreamAlias("medium_logo_url")
	@Column(name = "medium_logo_url")
	private String mediumLogoURL;

	@XStreamAlias("small_logo_url")
	@Column(name = "small_logo_url")
	private String smallLogoURL;

	@XStreamAlias("user_count")
	@Column(name = "user_count")
	private Long userCount;

	@XStreamAlias("average_rating")
	@Column(name = "average_rating")
	@XStreamConverter(value = NullableDoubleConverter.class)
	private Double averageRating;

	@XStreamAlias("rating_count")
	@Column(name = "rating_count")
	private Long ratingCount;

	@XStreamAlias("review_count")
	@Column(name = "review_count")
	private Long reviewCount;

	@XStreamAlias("analysis_id")
	@Column(name = "analysis_id")
	private Long analysisId;

	@OneToOne
	@JoinColumn(name = "analysis_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OhLohAnalysis analysis;

	@XStreamAlias("licenses")
	@OneToMany
	private List<OhLohLicense> ohLohLicenses;

	@XStreamAlias("tags")
	@OneToMany
	private List<OhLohTag> ohLohTags;

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

	public OhLohAnalysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(OhLohAnalysis analysis) {
		this.analysis = analysis;
	}

	public List<OhLohLicense> getOhLohLicenses() {
		return ohLohLicenses;
	}

	public void setOhLohLicenses(List<OhLohLicense> ohLohLicenses) {
		this.ohLohLicenses = ohLohLicenses;
	}

	public Long getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Long reviewCount) {
		this.reviewCount = reviewCount;
	}

	public List<OhLohTag> getOhLohTags() {
		return ohLohTags;
	}

	public void setOhLohTags(List<OhLohTag> ohLohTags) {
		this.ohLohTags = ohLohTags;
	}

}
