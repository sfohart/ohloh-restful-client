package br.ufba.dcc.mestrado.computacao.repository.impl;

import javax.persistence.TypedQuery;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerConfigEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohCrawlerConfigRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohCrawlerConfigRepository;

@OhLohCrawlerConfigRepositoryQualifier
public class OhLohCrawlerConfigRepositoryImpl extends BaseRepositoryImpl<OhLohCrawlerConfigEntity>
	implements OhLohCrawlerConfigRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohCrawlerConfigRepositoryImpl() {
		super(OhLohCrawlerConfigEntity.class);
	}

	@Override
	public OhLohCrawlerConfigEntity findCrawlerConfig() {		
		TypedQuery<OhLohCrawlerConfigEntity> crawlerConfig = super.createSelectAllQuery();		
		return crawlerConfig.getSingleResult();
	}

}
