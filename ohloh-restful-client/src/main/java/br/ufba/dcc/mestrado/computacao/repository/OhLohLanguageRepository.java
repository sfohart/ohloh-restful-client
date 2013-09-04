package br.ufba.dcc.mestrado.computacao.repository;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.language.OhLohLanguageEntity;

public interface OhLohLanguageRepository extends BaseRepository<Long, OhLohLanguageEntity>{

	public OhLohLanguageEntity findByName(String name);
	
}
