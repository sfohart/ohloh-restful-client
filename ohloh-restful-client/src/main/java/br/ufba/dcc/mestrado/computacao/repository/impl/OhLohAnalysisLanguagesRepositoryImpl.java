package br.ufba.dcc.mestrado.computacao.repository.impl;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisLanguagesEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohAnalysisLanguagesRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAnalysisLanguagesRepository;
import br.ufba.dcc.mestrado.computacao.transactions.Transactional;

@OhLohAnalysisLanguagesRepositoryQualifier
public class OhLohAnalysisLanguagesRepositoryImpl extends BaseRepositoryImpl<Long, OhLohAnalysisLanguagesEntity>
		implements OhLohAnalysisLanguagesRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohAnalysisLanguagesRepositoryImpl() {
		super(OhLohAnalysisLanguagesEntity.class);
	}

	@Override
	@Transactional
	public OhLohAnalysisLanguagesEntity findById(Long id) {
		OhLohAnalysisLanguagesEntity result = super.findById(id);
		
		if (result != null) {
			result.getContent();
		}
		
		return result;
	}
}
