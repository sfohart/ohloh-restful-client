package br.ufba.dcc.mestrado.computacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysisDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.language.OhLohLanguageDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisLanguageEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.language.OhLohLanguageEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.client.OhLohRestfulClient;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohAnalysisRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohLicenseRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohTagRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohAnalysisServiceQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohLanguageServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAnalysisRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohLicenseRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohTagRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohAnalysisService;
import br.ufba.dcc.mestrado.computacao.service.OhLohLanguageService;

@OhLohAnalysisServiceQualifier
public class OhLohAnalysisServiceImpl extends BaseOhLohServiceImpl<OhLohAnalysisDTO, Long, OhLohAnalysisEntity>
		implements OhLohAnalysisService {

	@Inject
	public OhLohAnalysisServiceImpl(@OhLohAnalysisRepositoryQualifier OhLohAnalysisRepository repository) {
		super(repository, OhLohAnalysisDTO.class, OhLohAnalysisEntity.class);
	}

	@Inject
	@OhLohAnalysisRepositoryQualifier
	private OhLohAnalysisRepository analysisRepository;
	
	@Inject
	private OhLohRestfulClient restfulClient;

	@Inject
	@OhLohTagRepositoryQualifier
	private OhLohTagRepository tagRepository;
	
	@Inject
	@OhLohLicenseRepositoryQualifier
	private OhLohLicenseRepository licenseRepository;
	
	@Inject
	@OhLohLanguageServiceQualifier
	private OhLohLanguageService languageService;
	
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
	public void validateEntity(OhLohAnalysisEntity entity) throws Exception {
		super.validateEntity(entity);
		
		if (entity != null) {
			if (entity.getOhLohAnalysisLanguages() != null && entity.getOhLohAnalysisLanguages().getContent() != null) {
				
				OhLohBaseRequest request = new OhLohBaseRequest();
				
				for (OhLohAnalysisLanguageEntity analysisLanguage : entity.getOhLohAnalysisLanguages().getContent()) {
					
					if (analysisLanguage.getLanguageId() != null && analysisLanguage.getLanguageId() > 0) {
						OhLohLanguageEntity language = languageService.findById(analysisLanguage.getLanguageId());
						
						if (language == null) {
							OhLohLanguageDTO languageDTO = restfulClient.getLanguageById(analysisLanguage.getLanguageId().toString(), request);
							language = languageService.buildEntity(languageDTO);
							languageService.validateEntity(language);
							
							analysisLanguage.setOhLohLanguage(language);
						}
					}
				}
			}
		}
	}
	
	@Override
	public OhLohAnalysisEntity process(OhLohAnalysisDTO dto) throws Exception{
		OhLohAnalysisEntity entity = super.process(dto);
		analysisRepository.save(entity);
		return entity;
	}

}
