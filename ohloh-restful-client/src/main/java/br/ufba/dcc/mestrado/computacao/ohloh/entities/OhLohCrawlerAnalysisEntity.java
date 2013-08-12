package br.ufba.dcc.mestrado.computacao.ohloh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = OhLohCrawlerAnalysisEntity.NODE_NAME)
public class OhLohCrawlerAnalysisEntity extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2489857720782899023L;
	
public final static String NODE_NAME = "crawler_analysis";
	

	
	@Column(name="start_at")
	private Integer startAt;
	
	@Column(name="offset_size")
	private Integer offsetSize;
	
	@Column(name="total_projects")
	private Long totalProjects;

	public Integer getStartAt() {
		return startAt;
	}

	public void setStartAt(Integer startAt) {
		this.startAt = startAt;
	}

	public Integer getOffset() {
		return offsetSize;
	}

	public void setOffset(Integer offset) {
		this.offsetSize = offset;
	}

	public Long getTotalProjects() {
		return totalProjects;
	}
	
	public void setTotalProjects(Long totalProjects) {
		this.totalProjects = totalProjects;
	}
	
}
