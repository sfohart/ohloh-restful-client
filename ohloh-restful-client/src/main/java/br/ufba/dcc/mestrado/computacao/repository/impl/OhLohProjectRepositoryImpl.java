package br.ufba.dcc.mestrado.computacao.repository.impl;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohProjectRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohProjectRepository;

@OhLohProjectRepositoryQualifier
public class OhLohProjectRepositoryImpl extends BaseRepositoryImpl<OhLohProjectEntity>
	implements OhLohProjectRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohProjectRepositoryImpl() {
		super(OhLohProjectEntity.class);
	}

}
