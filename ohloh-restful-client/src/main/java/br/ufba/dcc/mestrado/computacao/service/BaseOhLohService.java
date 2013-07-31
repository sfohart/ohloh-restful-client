package br.ufba.dcc.mestrado.computacao.service;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohResultDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;

public interface BaseOhLohService<DTO extends OhLohResultDTO, E extends OhLohBaseEntity> {

	public E store(DTO dto) throws Exception;
	
}
