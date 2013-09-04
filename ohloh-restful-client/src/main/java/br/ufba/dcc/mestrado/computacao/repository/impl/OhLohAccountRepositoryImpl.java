package br.ufba.dcc.mestrado.computacao.repository.impl;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.account.OhLohAccountEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohAccountRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAccountRepository;

@OhLohAccountRepositoryQualifier
public class OhLohAccountRepositoryImpl extends BaseRepositoryImpl<Long, OhLohAccountEntity>
		implements OhLohAccountRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohAccountRepositoryImpl() {
		super(OhLohAccountEntity.class);
	}

	
}
