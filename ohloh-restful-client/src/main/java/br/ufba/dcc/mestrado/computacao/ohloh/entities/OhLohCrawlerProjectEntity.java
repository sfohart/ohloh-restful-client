package br.ufba.dcc.mestrado.computacao.ohloh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = OhLohCrawlerProjectEntity.NODE_NAME)
public class OhLohCrawlerProjectEntity  implements OhLohBaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4564980589922044448L;
	
	public final static String NODE_NAME = "crawler_project";
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="project_current_page")
	private Integer projectCurrentPage;
	
	@Column(name="project_total_page")
	private Integer projectTotalPage;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProjectCurrentPage() {
		return projectCurrentPage;
	}
	
	public void setProjectCurrentPage(Integer projectCurrentPage) {
		this.projectCurrentPage = projectCurrentPage;
	}
	
	public Integer getProjectTotalPage() {
		return projectTotalPage;
	}
	
	public void setProjectTotalPage(Integer projectTotalPage) {
		this.projectTotalPage = projectTotalPage;
	}

}
