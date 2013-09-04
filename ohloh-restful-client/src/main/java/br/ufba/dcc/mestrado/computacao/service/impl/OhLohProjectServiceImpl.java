package br.ufba.dcc.mestrado.computacao.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysisDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohLicenseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohTagEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.client.OhLohRestfulClient;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohLicenseRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohProjectRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohTagRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohAnalysisServiceQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohProjectServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohLicenseRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohProjectRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohTagRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohAnalysisService;
import br.ufba.dcc.mestrado.computacao.service.OhLohProjectService;

@OhLohProjectServiceQualifier
public class OhLohProjectServiceImpl extends BaseOhLohServiceImpl<OhLohProjectDTO, Long, OhLohProjectEntity>
		implements OhLohProjectService {

	public OhLohProjectServiceImpl() {
		super(OhLohProjectDTO.class, OhLohProjectEntity.class);
	}

	@Inject
	@OhLohProjectRepositoryQualifier
	private OhLohProjectRepository projectRepository;

	@Inject
	@OhLohTagRepositoryQualifier
	private OhLohTagRepository tagRepository;
	
	@Inject
	@OhLohLicenseRepositoryQualifier
	private OhLohLicenseRepository licenseRepository;
	
	@Inject
	@OhLohAnalysisServiceQualifier
	private OhLohAnalysisService analysisService;
	
	@Inject
	private OhLohRestfulClient restfulClient;
	
	public Long countAll() {
		return projectRepository.countAll();
	}
	
	public OhLohProjectEntity findById(Long id) {
		return projectRepository.findById(id);
	}
	
	public List<OhLohProjectEntity> findAll(Integer startAt, Integer offset) {
		return projectRepository.findAll(startAt, offset);
	}
	
	@Override
	public void validateEntity(OhLohProjectEntity entity) throws Exception {
		super.validateEntity(entity);
		
		
		if (entity.getOhLohTags() != null) {
			List<OhLohTagEntity> tagList = new ArrayList<OhLohTagEntity>();
			Iterator<OhLohTagEntity> tagIterator = entity.getOhLohTags().iterator();
			while (tagIterator.hasNext()) {
				OhLohTagEntity tag = tagIterator.next();				
				OhLohTagEntity already = tagRepository.findByName(tag.getName());
				
				if (already != null) {
					tagList.add(already);
					tagIterator.remove();
				}
			}
			
			entity.getOhLohTags().addAll(tagList);
		}
		
		if (entity.getOhLohLicenses() != null) {
			List<OhLohLicenseEntity> licenseList = new ArrayList<OhLohLicenseEntity>();
			Iterator<OhLohLicenseEntity> licenseIterator = entity.getOhLohLicenses().iterator();
			
			while (licenseIterator.hasNext()) {
				OhLohLicenseEntity license = licenseIterator.next();
				OhLohLicenseEntity already = licenseRepository.findByName(license.getName());
				
				if (already != null) {
					licenseList.add(already);
					licenseIterator.remove();
				}
			}
			
			entity.getOhLohLicenses().addAll(licenseList);
		}
		
		if (entity.getAnalysisId() != null) {
			OhLohAnalysisEntity analysis = analysisService.findById(entity.getAnalysisId());
			
			OhLohBaseRequest request = new OhLohBaseRequest();
			
			if (analysis == null) {
				OhLohAnalysisDTO analysisDTO = restfulClient.getAnalysisById(entity.getId().toString(), entity.getAnalysisId().toString(), request);
				analysis = analysisService.buildEntity(analysisDTO);
				analysisService.validateEntity(analysis);
				
				entity.setOhLohAnalysis(analysis);
			}
		}
		
	}
	
	@Override
	public OhLohProjectEntity store(OhLohProjectDTO dto) throws Exception{
		OhLohProjectEntity entity = super.store(dto);
		projectRepository.save(entity);
		return entity;
	}

}
