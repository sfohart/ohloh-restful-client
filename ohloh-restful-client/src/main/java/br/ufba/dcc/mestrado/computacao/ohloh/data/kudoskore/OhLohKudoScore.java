package br.ufba.dcc.mestrado.computacao.ohloh.data.kudoskore;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601SqlTimestampConverter;

@XStreamAlias("kudo_score")
@Entity
@Table(name="ohoh_kudo_score")
public class OhLohKudoScore {

	@XStreamConverter(value=ISO8601SqlTimestampConverter.class)
	@XStreamAlias("created_at")
	private Timestamp createdAt;
	
	@XStreamAlias("kudo_rank")
	private Integer kudoRank;
	
	private Integer position;
	
	@XStreamAlias("max_position")
	private Integer maxPosition;
	
	@XStreamAlias("position_delta")
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
