package br.ufba.dcc.mestrado.computacao.repository.impl;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisLanguageEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohAnalysisLanguageRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAnalysisLanguageRepository;

@OhLohAnalysisLanguageRepositoryQualifier
public class OhLohAnalysisLanguageRepositoryImpl extends BaseRepositoryImpl<Long, OhLohAnalysisLanguageEntity>
		implements OhLohAnalysisLanguageRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohAnalysisLanguageRepositoryImpl() {
		super(OhLohAnalysisLanguageEntity.class);
	}

	
}
