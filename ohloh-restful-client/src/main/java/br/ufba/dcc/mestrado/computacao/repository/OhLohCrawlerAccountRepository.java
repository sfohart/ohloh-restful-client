package br.ufba.dcc.mestrado.computacao.repository;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohCrawlerAccountEntity;

public interface OhLohCrawlerAccountRepository extends BaseRepository<OhLohCrawlerAccountEntity>{
	
	public OhLohCrawlerAccountEntity findCrawlerConfig();
	
}
