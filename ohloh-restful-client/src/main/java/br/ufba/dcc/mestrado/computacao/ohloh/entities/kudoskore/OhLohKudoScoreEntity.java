package br.ufba.dcc.mestrado.computacao.ohloh.entities.kudoskore;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;

@Entity
@Table(name=OhLohKudoScoreEntity.NODE_NAME)
public class OhLohKudoScoreEntity extends OhLohBaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4697647432356330723L;

	public final static String NODE_NAME = "kudo_score";
	

	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="kudo_rank")
	private Integer kudoRank;
	
	@Column(name="position")
	private Integer position;
	
	@Column(name="max_position")
	private Integer maxPosition;
	
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
