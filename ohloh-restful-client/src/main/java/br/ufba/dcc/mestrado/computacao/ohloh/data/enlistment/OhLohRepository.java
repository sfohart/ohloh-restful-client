package br.ufba.dcc.mestrado.computacao.ohloh.data.enlistment;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohRepository.NODE_NAME)
@Entity
@Table(name="repository")
public class OhLohRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3900364356015056852L;

	public enum OhLohRepositoryTypeEnum {
		SvnRepository,
		CvsRepository,
		GitRepository,
		HgRepository,
		BzrRepository,
		SvnSyncRepository
	}
	
	public final static String NODE_NAME = "repository";
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="type")
	private OhLohRepositoryTypeEnum type;
	
	@Column(name="url")
	private String url;
	
	@XStreamAlias("module_name")
	@Column(name="module_name")
	private String moduleName;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("logged_at")
	@Column(name="logged_at")
	private Timestamp loggedAt;
	
	@Column(name="commits")
	private Long commits;
	
	@XStreamAlias("ohloh_job_status")
	@Column(name="ohloh_job_status")
	private String ohlohJobStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OhLohRepositoryTypeEnum getType() {
		return type;
	}

	public void setType(OhLohRepositoryTypeEnum type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLoggedAt() {
		return loggedAt;
	}

	public void setLoggedAt(Timestamp loggedAt) {
		this.loggedAt = loggedAt;
	}

	public Long getCommits() {
		return commits;
	}

	public void setCommits(Long commits) {
		this.commits = commits;
	}

	public String getOhlohJobStatus() {
		return ohlohJobStatus;
	}

	public void setOhlohJobStatus(String ohlohJobStatus) {
		this.ohlohJobStatus = ohlohJobStatus;
	}
	
	
}
