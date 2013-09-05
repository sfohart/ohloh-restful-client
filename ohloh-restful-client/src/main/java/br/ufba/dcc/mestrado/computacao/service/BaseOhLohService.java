package br.ufba.dcc.mestrado.computacao.service;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohResultDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;

public interface BaseOhLohService<DTO extends OhLohResultDTO, ID extends Number, E extends OhLohBaseEntity<ID>> {

	public E process(DTO dto) throws Exception;
	
	public E buildEntity(DTO dto) throws Exception;
	
	public void validateEntity(E entity) throws Exception;

	public abstract E saveEntity(E entity) throws Exception;
}
