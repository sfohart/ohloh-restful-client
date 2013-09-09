package br.ufba.dcc.mestrado.computacao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysisDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.language.OhLohLanguageDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisLanguageEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisLanguagesEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.language.OhLohLanguageEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.client.OhLohRestfulClient;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohAnalysisLanguagesRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohAnalysisRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohLicenseRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohTagRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohAnalysisServiceQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohLanguageServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAnalysisLanguagesRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAnalysisRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohLicenseRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohTagRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohAnalysisService;
import br.ufba.dcc.mestrado.computacao.service.OhLohLanguageService;

@OhLohAnalysisServiceQualifier
public class OhLohAnalysisServiceImpl extends BaseOhLohServiceImpl<OhLohAnalysisDTO, Long, OhLohAnalysisEntity>
		implements OhLohAnalysisService {

	private Logger logger = Logger.getLogger(OhLohAnalysisServiceImpl.class.getName());
	
	@Inject
	public OhLohAnalysisServiceImpl(@OhLohAnalysisRepositoryQualifier OhLohAnalysisRepository repository) {
		super(repository, OhLohAnalysisDTO.class, OhLohAnalysisEntity.class);
	}

	@Inject
	@OhLohAnalysisRepositoryQualifier
	private OhLohAnalysisRepository analysisRepository;
	
	@Inject
	@OhLohAnalysisLanguagesRepositoryQualifier
	private OhLohAnalysisLanguagesRepository analysisLanguagesRepository;
	
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
				
				
				OhLohAnalysisLanguagesEntity analysisLanguagesEntity = analysisLanguagesRepository.findById(entity.getOhLohAnalysisLanguages().getId());
				if (analysisLanguagesEntity != null) {
					entity.setOhLohAnalysisLanguages(analysisLanguagesEntity);
				}
				
				List<OhLohAnalysisLanguageEntity> analysisLanguageList = new ArrayList<>();
				
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
					
					analysisLanguageList.add(analysisLanguage);
				}
				
				entity.getOhLohAnalysisLanguages().getContent().clear();
				entity.getOhLohAnalysisLanguages().getContent().addAll(analysisLanguageList);
			}
		}
	}
	
	@Override
	public OhLohAnalysisEntity process(OhLohAnalysisDTO dto) throws Exception{
		OhLohAnalysisEntity entity = super.process(dto);
		logger.info(String.format("Salvando entidade %s com id %d para o projeto %d", entity.getClass().getName(), entity.getId(), entity.getOhlohProject().getId()));
		analysisRepository.save(entity);
		return entity;
	}

}
