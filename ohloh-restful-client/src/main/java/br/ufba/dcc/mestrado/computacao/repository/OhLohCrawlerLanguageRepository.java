package br.ufba.dcc.mestrado.computacao.repository;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerLanguageEntity;

public interface OhLohCrawlerLanguageRepository extends BaseRepository<Long, OhLohCrawlerLanguageEntity>{
	
	public OhLohCrawlerLanguageEntity findCrawlerConfig();
	
}
