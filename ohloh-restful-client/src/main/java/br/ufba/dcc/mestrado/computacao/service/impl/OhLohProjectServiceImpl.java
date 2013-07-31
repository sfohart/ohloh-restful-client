package br.ufba.dcc.mestrado.computacao.service.impl;

import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohProjectRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohProjectServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohProjectRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohProjectService;

@OhLohProjectServiceQualifier
public class OhLohProjectServiceImpl implements OhLohProjectService {

	@Inject
	@OhLohProjectRepositoryQualifier
	private OhLohProjectRepository projectRepository;
	
	@Override
	public OhLohProjectEntity store(OhLohProjectDTO dto) throws Exception{
		OhLohProjectEntity entity = new OhLohProjectEntity();		
		BeanUtils.copyProperties(entity, dto);
		
		projectRepository.add(entity);
		
		return entity;
	}

}
