package br.ufba.dcc.mestrado.computacao.repository.impl;

import javax.persistence.TypedQuery;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerProjectEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohCrawlerProjectRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohCrawlerProjectRepository;

@OhLohCrawlerProjectRepositoryQualifier
public class OhLohCrawlerProjectRepositoryImpl extends BaseRepositoryImpl<OhLohCrawlerProjectEntity>
	implements OhLohCrawlerProjectRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohCrawlerProjectRepositoryImpl() {
		super(OhLohCrawlerProjectEntity.class);
	}

	@Override
	public OhLohCrawlerProjectEntity findCrawlerConfig() {		
		TypedQuery<OhLohCrawlerProjectEntity> crawlerConfig = super.createSelectAllQuery();		
		return crawlerConfig.getSingleResult();
	}

}
