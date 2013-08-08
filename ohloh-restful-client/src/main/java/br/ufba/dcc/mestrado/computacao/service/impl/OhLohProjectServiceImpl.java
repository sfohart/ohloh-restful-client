package br.ufba.dcc.mestrado.computacao.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohLicenseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohTagEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohLicenseRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohProjectRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohProjectServiceQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohTagRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohLicenseRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohProjectRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohTagRepository;
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

	@Inject
	@OhLohTagRepositoryQualifier
	private OhLohTagRepository tagRepository;
	
	@Inject
	@OhLohLicenseRepositoryQualifier
	private OhLohLicenseRepository licenseRepository;
	
	public Long countAll() {
		return projectRepository.countAll();
	}
	
	@Override
	protected void validateEntity(OhLohProjectEntity entity) throws Exception {
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
		
	}
	
	@Override
	public OhLohProjectEntity store(OhLohProjectDTO dto) throws Exception{
		OhLohProjectEntity entity = super.store(dto);
		projectRepository.save(entity);
		return entity;
	}

}
