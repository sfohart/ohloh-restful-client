package br.ufba.dcc.mestrado.computacao.service.impl;

import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohResultDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.service.BaseOhLohService;
import br.ufba.dcc.mestrado.computacao.util.ConverterHandler;

public abstract class BaseOhLohServiceImpl<DTO extends OhLohResultDTO, ID extends Number, E extends OhLohBaseEntity<ID>>
		implements BaseOhLohService<DTO, ID, E> {

	private Class<DTO> dtoClass;
	private Class<E> entityClass;
	
	private ConverterHandler<DTO, ID, E> converterUtil;

	@Override
	public E store(DTO dto) throws Exception {
		E entity = buildEntity(dto);
		
		validateEntity(entity);
		
		return entity;
	}
	
	public BaseOhLohServiceImpl(Class<DTO> dtoClass, Class<E> entityClass) {
		this.dtoClass = dtoClass;
		this.entityClass = entityClass;
		this.converterUtil = new ConverterHandler<DTO, ID, E>(dtoClass,entityClass);
	}
	
	public void validateEntity(E entity) throws Exception {
		
	}
	
	public E buildEntity(DTO dto) throws Exception {
		E entity = (E) converterUtil.buildEntity(dto);
		return entity;
	}


}
