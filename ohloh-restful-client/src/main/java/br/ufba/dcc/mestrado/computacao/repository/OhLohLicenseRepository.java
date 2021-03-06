package br.ufba.dcc.mestrado.computacao.repository;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohLicenseEntity;

public interface OhLohLicenseRepository extends BaseRepository<Long, OhLohLicenseEntity>{

	public OhLohLicenseEntity findByName(String name);
	
}
