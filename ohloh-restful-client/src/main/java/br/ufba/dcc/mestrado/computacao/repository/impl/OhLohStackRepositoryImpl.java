package br.ufba.dcc.mestrado.computacao.repository.impl;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.stack.OhLohStackEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohStackRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohStackRepository;

@OhLohStackRepositoryQualifier
public class OhLohStackRepositoryImpl extends
		BaseRepositoryImpl<Long, OhLohStackEntity> implements OhLohStackRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohStackRepositoryImpl() {
		super(OhLohStackEntity.class);
	}

}
