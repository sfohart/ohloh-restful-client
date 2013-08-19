package br.ufba.dcc.mestrado.computacao.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerAccountEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohCrawlerAccountRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohCrawlerAccountRepository;

@OhLohCrawlerAccountRepositoryQualifier
public class OhLohCrawlerAccountRepositoryImpl extends BaseRepositoryImpl<OhLohCrawlerAccountEntity>
	implements OhLohCrawlerAccountRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohCrawlerAccountRepositoryImpl() {
		super(OhLohCrawlerAccountEntity.class);
	}

	@Override
	public OhLohCrawlerAccountEntity findCrawlerConfig() {		
		OhLohCrawlerAccountEntity config = null;
		TypedQuery<OhLohCrawlerAccountEntity> crawlerConfig = super.createSelectAllQuery();
		
		try {
			config =  crawlerConfig.getSingleResult();
		} catch (NoResultException ex) {			
		}
		
		return config;
	}

}
