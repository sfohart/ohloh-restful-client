package br.ufba.dcc.mestrado.computacao.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerStackEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohCrawlerStackRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohCrawlerStackRepository;

@OhLohCrawlerStackRepositoryQualifier
public class OhLohCrawlerStackRepositoryImpl extends BaseRepositoryImpl<Long, OhLohCrawlerStackEntity>
	implements OhLohCrawlerStackRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohCrawlerStackRepositoryImpl() {
		super(OhLohCrawlerStackEntity.class);
	}

	@Override
	public OhLohCrawlerStackEntity findCrawlerConfig() {		
		TypedQuery<OhLohCrawlerStackEntity> crawlerConfig = super.createSelectAllQuery();	
		
		OhLohCrawlerStackEntity result =  null;
		
		try {
			result = crawlerConfig.getSingleResult();
		} catch (NoResultException ex) {
		}
		
		return result;
	}

}
