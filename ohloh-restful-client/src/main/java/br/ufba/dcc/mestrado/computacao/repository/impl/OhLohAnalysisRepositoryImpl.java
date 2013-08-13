package br.ufba.dcc.mestrado.computacao.repository.impl;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohAnalysisRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAnalysisRepository;

@OhLohAnalysisRepositoryQualifier
public class OhLohAnalysisRepositoryImpl extends BaseRepositoryImpl<OhLohAnalysisEntity>
			implements OhLohAnalysisRepository {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7186645542252274075L;
	
	public OhLohAnalysisRepositoryImpl() {
		super(OhLohAnalysisEntity.class);
		// TODO Auto-generated constructor stub
	}

}
