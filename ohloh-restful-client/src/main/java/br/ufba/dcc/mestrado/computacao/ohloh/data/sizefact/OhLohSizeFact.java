package br.ufba.dcc.mestrado.computacao.ohloh.data.sizefact;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableDoubleConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias("size_fact")
@Entity
@Table(name="ohoh_size_fact")
public class OhLohSizeFact {

	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	private Timestamp month;
	
	private Long code;
	
	private Long comments;
	
	private Long blanks;
	
	@XStreamAlias("comment_ratio")
	@XStreamConverter(value=NullableDoubleConverter.class)
	private Double commentRatio;
	
	private String commits;
	
	@XStreamAlias("man_months")
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
