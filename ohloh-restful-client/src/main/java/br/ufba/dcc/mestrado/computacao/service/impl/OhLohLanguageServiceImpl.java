package br.ufba.dcc.mestrado.computacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import br.ufba.dcc.mestrado.computacao.ohloh.data.language.OhLohLanguageDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.language.OhLohLanguageEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohLanguageRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohLanguageServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohLanguageRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohLanguageService;

@OhLohLanguageServiceQualifier
public class OhLohLanguageServiceImpl extends BaseOhLohServiceImpl<OhLohLanguageDTO, Long, OhLohLanguageEntity>
		implements OhLohLanguageService {

	public OhLohLanguageServiceImpl() {
		super(OhLohLanguageDTO.class, OhLohLanguageEntity.class);
	}

	@Inject
	@OhLohLanguageRepositoryQualifier
	private OhLohLanguageRepository languageRepository;
	
	
	public Long countAll() {
		return languageRepository.countAll();
	}
	
	public OhLohLanguageEntity findById(Long id) {
		return languageRepository.findById(id);
	}
	
	public List<OhLohLanguageEntity> findAll(Integer startAt, Integer offset) {
		return languageRepository.findAll(startAt, offset);
	}
	
	@Override
	public OhLohLanguageEntity store(OhLohLanguageDTO dto) throws Exception{
		OhLohLanguageEntity entity = super.store(dto);
		languageRepository.save(entity);
		return entity;
	}

}
