package br.ufba.dcc.mestrado.computacao.ohloh.entities.account;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.kudoskore.OhLohKudoScoreEntity;

@Entity
@Table(name = OhLohAccountEntity.NODE_NAME)
public class OhLohAccountEntity extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4161579546763839506L;

	public final static String NODE_NAME = "account";

	/**
	 * The public name for this Account.
	 */
	@Column(name = "name")
	private String name;

	@Column(name = "about")
	private String about;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "homepage_url")
	private String homepageURL;

	@Column(name = "avatar_url")
	private String avatarURL;

	@Column(name = "email_sha1")
	private String emailSHA1;

	@Column(name = "posts_count")
	private Long postsCount;

	@Column(name = "location")
	private String location;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

	@OneToOne
	@JoinColumn(name = "kudo_score_id", referencedColumnName = "id")
	private OhLohKudoScoreEntity ohLohKudoScoreEntity;

	@Column(name = "url")
	private String url;

	@Column(name = "html_url")
	private String htmlURL;

	@Column(name = "login")
	private String login;

	@Column(name = "twitter_account")
	private String twitterAccount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
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

	public String getHomepageURL() {
		return homepageURL;
	}

	public void setHomepageURL(String homepageURL) {
		this.homepageURL = homepageURL;
	}

	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}

	public String getEmailSHA1() {
		return emailSHA1;
	}

	public void setEmailSHA1(String emailSHA1) {
		this.emailSHA1 = emailSHA1;
	}

	public Long getPostsCount() {
		return postsCount;
	}

	public void setPostsCount(Long postsCount) {
		this.postsCount = postsCount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public OhLohKudoScoreEntity getOhLohKudoScore() {
		return ohLohKudoScoreEntity;
	}

	public void setOhLohKudoScore(OhLohKudoScoreEntity ohLohKudoScoreEntity) {
		this.ohLohKudoScoreEntity = ohLohKudoScoreEntity;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTwitterAccount() {
		return twitterAccount;
	}

	public void setTwitterAccount(String twitterAccount) {
		this.twitterAccount = twitterAccount;
	}

}
