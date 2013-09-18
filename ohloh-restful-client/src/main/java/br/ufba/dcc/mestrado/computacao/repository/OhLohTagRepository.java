package br.ufba.dcc.mestrado.computacao.repository;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohTagEntity;

public interface OhLohTagRepository extends BaseRepository<Long, OhLohTagEntity>{

	public OhLohTagEntity findByName(String name);
	
}
