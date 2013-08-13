package br.ufba.dcc.mestrado.computacao.ohloh.data.sizefact;

import java.sql.Timestamp;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohResultDTO;
import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableDoubleXStreamConverter;
import br.ufba.dcc.mestrado.computacao.xstream.converters.NullableLongXStreamConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohSizeFactDTO.NODE_NAME)
public class OhLohSizeFactDTO implements OhLohResultDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5308357200941776405L;

	public final static String NODE_NAME = "size_fact";
	
	@XStreamAsAttribute	
	@XStreamConverter(value=NullableLongXStreamConverter.class)
	private Long id;

	@XStreamConverter(value = ISO8601SqlTimestampConverter.class)
	private Timestamp month;

	@XStreamConverter(value=NullableLongXStreamConverter.class)
	private Long code;

	@XStreamConverter(value=NullableLongXStreamConverter.class)
	private Long comments;

	@XStreamConverter(value=NullableLongXStreamConverter.class)
	private Long blanks;

	@XStreamAlias("comment_ratio")
	@XStreamConverter(value = NullableDoubleXStreamConverter.class)
	private Double commentRatio;

	private String commits;

	@XStreamAlias("man_months")
	private Long manMonths;

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

	public Long getManMonths() {
		return manMonths;
	}

	public void setManMonths(Long manMonths) {
		this.manMonths = manMonths;
	}

}
