package br.ufba.dcc.mestrado.computacao.service;

import java.util.List;

import br.ufba.dcc.mestrado.computacao.ohloh.data.language.OhLohLanguageDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.language.OhLohLanguageEntity;

public interface OhLohLanguageService extends BaseOhLohService<OhLohLanguageDTO, Long, OhLohLanguageEntity>{

	public Long countAll();
	
	public OhLohLanguageEntity findById(Long id);
	
	public List<OhLohLanguageEntity> findAll(Integer startAt, Integer offset);
	
}
