package br.ufba.dcc.mestrado.computacao.ohloh.data.activityfact;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohActivityFact.NODE_NAME)
@Entity
@Table(name="activity_fact")
public class OhLohActivityFact extends OhLohBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1220433997459663718L;

	public final static String NODE_NAME = "activity_fact";
	


	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@Column(name="month")
	private Timestamp month;
	
	@XStreamAlias("code_added")
	@Column(name="code_added")
	private Long codeAdded;
	
	@XStreamAlias("code_removed")
	@Column(name="code_removed")
	private Long codeRemoved;
	
	@XStreamAlias("comments_added")
	@Column(name="comments_added")
	private Long commentsAdded;
	
	@XStreamAlias("comments_removed")
	@Column(name="comments_removed")
	private Long commentsRemoved;
	
	@XStreamAlias("blanks_added")
	@Column(name="blanks_added")
	private Long blanksAdded;
	
	@XStreamAlias("blanks_removed")
	@Column(name="blanks_removed")
	private Long blanksRemoved;
	
	@Column(name="commits")
	private Long commits;
	
	@Column(name="contributors")
	private Long contributors;

	public Timestamp getMonth() {
		return month;
	}

	public void setMonth(Timestamp month) {
		this.month = month;
	}

	public Long getCodeAdded() {
		return codeAdded;
	}

	public void setCodeAdded(Long codeAdded) {
		this.codeAdded = codeAdded;
	}

	public Long getCodeRemoved() {
		return codeRemoved;
	}

	public void setCodeRemoved(Long codeRemoved) {
		this.codeRemoved = codeRemoved;
	}

	public Long getCommentsAdded() {
		return commentsAdded;
	}

	public void setCommentsAdded(Long commentsAdded) {
		this.commentsAdded = commentsAdded;
	}

	public Long getCommentsRemoved() {
		return commentsRemoved;
	}

	public void setCommentsRemoved(Long commentsRemoved) {
		this.commentsRemoved = commentsRemoved;
	}

	public Long getBlanksAdded() {
		return blanksAdded;
	}

	public void setBlanksAdded(Long blanksAdded) {
		this.blanksAdded = blanksAdded;
	}

	public Long getBlanksRemoved() {
		return blanksRemoved;
	}

	public void setBlanksRemoved(Long blanksRemoved) {
		this.blanksRemoved = blanksRemoved;
	}

	public Long getCommits() {
		return commits;
	}

	public void setCommits(Long commits) {
		this.commits = commits;
	}

	public Long getContributors() {
		return contributors;
	}

	public void setContributors(Long contributors) {
		this.contributors = contributors;
	}

		
}
