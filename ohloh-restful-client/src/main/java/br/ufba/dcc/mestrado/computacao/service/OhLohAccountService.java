package br.ufba.dcc.mestrado.computacao.service;

import java.util.List;

import br.ufba.dcc.mestrado.computacao.ohloh.data.account.OhLohAccountDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.account.OhLohAccountEntity;

public interface OhLohAccountService extends BaseOhLohService<OhLohAccountDTO, OhLohAccountEntity>{

	public Long countAll();
	
	public OhLohAccountEntity findById(Long id);
	
	public List<OhLohAccountEntity> findAll(Integer startAt, Integer offset);
	
}
