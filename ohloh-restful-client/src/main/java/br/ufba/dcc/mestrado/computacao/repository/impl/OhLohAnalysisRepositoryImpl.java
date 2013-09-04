package br.ufba.dcc.mestrado.computacao.repository.impl;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohAnalysisRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAnalysisRepository;

@OhLohAnalysisRepositoryQualifier
public class OhLohAnalysisRepositoryImpl extends BaseRepositoryImpl<Long, OhLohAnalysisEntity>
		implements OhLohAnalysisRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohAnalysisRepositoryImpl() {
		super(OhLohAnalysisEntity.class);
	}

	
}
