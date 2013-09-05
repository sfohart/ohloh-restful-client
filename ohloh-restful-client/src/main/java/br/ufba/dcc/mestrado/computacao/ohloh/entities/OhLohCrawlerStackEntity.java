package br.ufba.dcc.mestrado.computacao.ohloh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;

@Entity
@Table(name = OhLohCrawlerStackEntity.NODE_NAME)
public class OhLohCrawlerStackEntity  implements OhLohBaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4564980589922044448L;
	
	public final static String NODE_NAME = "crawler_stack";
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="items_available")
	private Integer itemsAvailable;
	
	@Column(name="total_page")
	private Integer totalPage;
	
	@Column(name="current_page")
	private Integer currentPage;
	
	@Column(name="items_per_page")
	private Integer itemsPerPage;
	
	@ManyToOne
	private OhLohProjectEntity ohLohProject;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getItemsAvailable() {
		return itemsAvailable;
	}

	public void setItemsAvailable(Integer itemsAvailable) {
		this.itemsAvailable = itemsAvailable;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public OhLohProjectEntity getOhLohProject() {
		return ohLohProject;
	}

	public void setOhLohProject(OhLohProjectEntity ohLohProject) {
		this.ohLohProject = ohLohProject;
	}
	
}
