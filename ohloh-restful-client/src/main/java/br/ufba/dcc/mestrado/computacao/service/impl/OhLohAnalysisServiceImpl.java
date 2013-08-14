package br.ufba.dcc.mestrado.computacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysisDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisLanguagesEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohAnalysisLanguagesRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohAnalysisRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohAnalysisServiceQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohLicenseRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohTagRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAnalysisLanguagesRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAnalysisRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohLicenseRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohTagRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohAnalysisService;

@OhLohAnalysisServiceQualifier
public class OhLohAnalysisServiceImpl extends BaseOhLohServiceImpl<OhLohAnalysisDTO, OhLohAnalysisEntity>
		implements OhLohAnalysisService {

	public OhLohAnalysisServiceImpl() {
		super(OhLohAnalysisDTO.class, OhLohAnalysisEntity.class);
	}

	@Inject
	@OhLohAnalysisRepositoryQualifier
	private OhLohAnalysisRepository analysisRepository;
	
	@Inject
	@OhLohAnalysisLanguagesRepositoryQualifier
	private OhLohAnalysisLanguagesRepository analysisLanguagesRepository;  

	@Inject
	@OhLohTagRepositoryQualifier
	private OhLohTagRepository tagRepository;
	
	@Inject
	@OhLohLicenseRepositoryQualifier
	private OhLohLicenseRepository licenseRepository;
	
	public Long countAll() {
		return analysisRepository.countAll();
	}
	
	public OhLohAnalysisEntity findById(Long id) {
		return analysisRepository.findById(id);
	}
	
	public List<OhLohAnalysisEntity> findAll(Integer startAt, Integer offset) {
		return analysisRepository.findAll(startAt, offset);
	}
	
	
	@Override
	public OhLohAnalysisEntity store(OhLohAnalysisDTO dto) throws Exception{
		OhLohAnalysisEntity entity = super.store(dto);
		analysisRepository.save(entity);
		return entity;
	}

}
