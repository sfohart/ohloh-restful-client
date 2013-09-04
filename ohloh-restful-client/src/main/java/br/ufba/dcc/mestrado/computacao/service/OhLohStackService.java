package br.ufba.dcc.mestrado.computacao.service;

import java.util.List;

import br.ufba.dcc.mestrado.computacao.ohloh.data.stack.OhLohStackDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.stack.OhLohStackEntity;

public interface OhLohStackService extends BaseOhLohService<OhLohStackDTO, Long, OhLohStackEntity>{

	public Long countAll();
	
	public OhLohStackEntity findById(Long id);
	
	public List<OhLohStackEntity> findAll(Integer startAt, Integer offset);
	
}
