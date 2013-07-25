package br.ufba.dcc.mestrado.computacao.repository.impl;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProject;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohProjectQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohProjectRepository;

@OhLohProjectQualifier
public class OhLohProjectRepositoryImpl extends BaseRepositoryImpl<Long, OhLohProject>
	implements OhLohProjectRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

}
