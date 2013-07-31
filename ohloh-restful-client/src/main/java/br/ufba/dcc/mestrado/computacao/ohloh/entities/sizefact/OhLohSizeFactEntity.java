package br.ufba.dcc.mestrado.computacao.ohloh.entities.sizefact;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;

@Entity
@Table(name = OhLohSizeFactEntity.NODE_NAME)
public class OhLohSizeFactEntity extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5308357200941776405L;

	public final static String NODE_NAME = "size_fact";

	@Column(name = "month")
	private Timestamp month;

	@Column(name = "code")
	private Long code;

	@Column(name = "comments")
	private Long comments;

	@Column(name = "blanks")
	private Long blanks;

	@Column(name = "comment_ratio")
	private Double commentRatio;

	@Column(name = "commits")
	private String commits;

	@Column(name = "man_months")
	private Integer manMonths;

	public Timestamp getMonth() {
		return month;
	}

	public void setMonth(Timestamp month) {
		this.month = month;
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

	public String getCommits() {
		return commits;
	}

	public void setCommits(String commits) {
		this.commits = commits;
	}

	public Integer getManMonths() {
		return manMonths;
	}

	public void setManMonths(Integer manMonths) {
		this.manMonths = manMonths;
	}

}
