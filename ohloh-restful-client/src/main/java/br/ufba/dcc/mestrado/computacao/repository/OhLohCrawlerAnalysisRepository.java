package br.ufba.dcc.mestrado.computacao.repository;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerAnalysisEntity;

public interface OhLohCrawlerAnalysisRepository extends BaseRepository<OhLohCrawlerAnalysisEntity>{
	
	public OhLohCrawlerAnalysisEntity findCrawlerConfig();
	
}
