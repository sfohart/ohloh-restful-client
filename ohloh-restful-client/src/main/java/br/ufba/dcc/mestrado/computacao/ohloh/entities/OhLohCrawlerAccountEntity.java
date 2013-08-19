package br.ufba.dcc.mestrado.computacao.ohloh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = OhLohCrawlerAccountEntity.NODE_NAME)
public class OhLohCrawlerAccountEntity  extends OhLohBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4564980589922044448L;
	
	public final static String NODE_NAME = "crawler_account";
	
	@Column(name="account_current_page")
	private Integer accountCurrentPage;
	
	@Column(name="account_total_page")
	private Integer accountTotalPage;

	public Integer getAccountCurrentPage() {
		return accountCurrentPage;
	}

	public void setAccountCurrentPage(Integer accountCurrentPage) {
		this.accountCurrentPage = accountCurrentPage;
	}

	public Integer getAccountTotalPage() {
		return accountTotalPage;
	}

	public void setAccountTotalPage(Integer accountTotalPage) {
		this.accountTotalPage = accountTotalPage;
	}
	
	

}
