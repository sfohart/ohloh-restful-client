package br.ufba.dcc.mestrado.computacao.service.impl;

import javax.inject.Inject;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohProjectRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohProjectServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohProjectRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohProjectService;

@OhLohProjectServiceQualifier
public class OhLohProjectServiceImpl extends BaseOhLohServiceImpl<OhLohProjectDTO, OhLohProjectEntity>
		implements OhLohProjectService {

	public OhLohProjectServiceImpl() {
		super(OhLohProjectDTO.class, OhLohProjectEntity.class);
	}

	@Inject
	@OhLohProjectRepositoryQualifier
	private OhLohProjectRepository projectRepository;
	
	@Override
	public OhLohProjectEntity store(OhLohProjectDTO dto) throws Exception{
		OhLohProjectEntity entity = buildEntity(dto);
		projectRepository.save(entity);
		return entity;
	}

}
