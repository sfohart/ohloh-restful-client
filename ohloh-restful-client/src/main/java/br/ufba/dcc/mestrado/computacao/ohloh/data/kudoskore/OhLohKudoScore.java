package br.ufba.dcc.mestrado.computacao.ohloh.data.kudoskore;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohBaseEntity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias(OhLohKudoScore.NODE_NAME)
@Entity
@Table(name="kudo_score")
public class OhLohKudoScore extends OhLohBaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4697647432356330723L;

	public final static String NODE_NAME = "kudo_score";
	

	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("created_at")
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@XStreamAlias("kudo_rank")
	@Column(name="kudo_rank")
	private Integer kudoRank;
	
	@Column(name="position")
	private Integer position;
	
	@XStreamAlias("max_position")
	@Column(name="max_position")
	private Integer maxPosition;
	
	@XStreamAlias("position_delta")
	@Column(name="position_delta")
	private Integer positionDelta;

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getKudoRank() {
		return kudoRank;
	}

	public void setKudoRank(Integer kudoRank) {
		this.kudoRank = kudoRank;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getMaxPosition() {
		return maxPosition;
	}

	public void setMaxPosition(Integer maxPosition) {
		this.maxPosition = maxPosition;
	}

	public Integer getPositionDelta() {
		return positionDelta;
	}

	public void setPositionDelta(Integer positionDelta) {
		this.positionDelta = positionDelta;
	}


}
