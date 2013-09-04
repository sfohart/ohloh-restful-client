package br.ufba.dcc.mestrado.computacao.ohloh.entities.language;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;

@Entity
@Table(name = OhLohLanguageEntity.NODE_NAME)
public class OhLohLanguageEntity implements OhLohBaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2035131004549723264L;

	public final static String NODE_NAME = "language";
	
	@Id
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(name = "nice_name")
	private String niceName;
	
	private String category;
	
	private Long code;
	
	private Long comments;
	
	private Long blanks;
	
	@Column(name = "comment_ratio")
	private Double commentRatio;
	
	private Long projects;
	
	private Long contributors;
	
	private Long commits;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNiceName() {
		return niceName;
	}

	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getComments() {
		return comments;
	}

	public void setComments(Long comments) {
		this.comments = comments;
	}

	public Long getBlanks() {
		return blanks;
	}

	public void setBlanks(Long blanks) {
		this.blanks = blanks;
	}

	public Double getCommentRatio() {
		return commentRatio;
	}

	public void setCommentRatio(Double commentRatio) {
		this.commentRatio = commentRatio;
	}

	public Long getProjects() {
		return projects;
	}

	public void setProjects(Long projects) {
		this.projects = projects;
	}

	public Long getContributors() {
		return contributors;
	}

	public void setContributors(Long contributors) {
		this.contributors = contributors;
	}

	public Long getCommits() {
		return commits;
	}

	public void setCommits(Long commits) {
		this.commits = commits;
	}
	

}
