package br.ufba.dcc.mestrado.computacao.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerLanguageEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohCrawlerLanguageRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohCrawlerLanguageRepository;

@OhLohCrawlerLanguageRepositoryQualifier
public class OhLohCrawlerLanguageRepositoryImpl extends BaseRepositoryImpl<Long, OhLohCrawlerLanguageEntity>
	implements OhLohCrawlerLanguageRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohCrawlerLanguageRepositoryImpl() {
		super(OhLohCrawlerLanguageEntity.class);
	}

	@Override
	public OhLohCrawlerLanguageEntity findCrawlerConfig() {		
		TypedQuery<OhLohCrawlerLanguageEntity> crawlerConfig = super.createSelectAllQuery();		
		OhLohCrawlerLanguageEntity result = null;
		
		try {
			result = crawlerConfig.getSingleResult();
		} catch (NoResultException ex) {
		}
		
		return result;
	}

}
