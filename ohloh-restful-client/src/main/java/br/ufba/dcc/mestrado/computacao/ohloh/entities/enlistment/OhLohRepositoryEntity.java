package br.ufba.dcc.mestrado.computacao.ohloh.entities.enlistment;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;

@Entity
@Table(name = OhLohRepositoryEntity.NODE_NAME)
public class OhLohRepositoryEntity implements OhLohBaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3900364356015056852L;

	public enum OhLohRepositoryTypeEnum {
		SvnRepository, CvsRepository, GitRepository, HgRepository, BzrRepository, SvnSyncRepository
	}

	public final static String NODE_NAME = "repository";

	@Id
	private Long id;
	
	@Column(name = "type")
	private OhLohRepositoryTypeEnum type;

	@Column(name = "url")
	private String url;

	@Column(name = "module_name")
	private String moduleName;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "logged_at")
	private Timestamp loggedAt;

	@Column(name = "commits")
	private Long commits;

	@Column(name = "ohloh_job_status")
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
