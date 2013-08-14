package br.ufba.dcc.mestrado.computacao.repository.impl;

import javax.persistence.TypedQuery;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerAnalysisEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohCrawlerAnalysisRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohCrawlerAnalysisRepository;

@OhLohCrawlerAnalysisRepositoryQualifier
public class OhLohCrawlerAnalysisRepositoryImpl extends BaseRepositoryImpl<OhLohCrawlerAnalysisEntity>
	implements OhLohCrawlerAnalysisRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohCrawlerAnalysisRepositoryImpl() {
		super(OhLohCrawlerAnalysisEntity.class);
	}

	@Override
	public OhLohCrawlerAnalysisEntity findCrawlerConfig() {		
		TypedQuery<OhLohCrawlerAnalysisEntity> crawlerConfig = super.createSelectAllQuery();		
		return crawlerConfig.getSingleResult();
	}

}
