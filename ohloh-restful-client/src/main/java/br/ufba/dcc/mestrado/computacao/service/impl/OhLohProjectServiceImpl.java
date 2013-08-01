package br.ufba.dcc.mestrado.computacao.service.impl;

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
	
	@Override
	protected void validateEntity(OhLohProjectEntity entity) throws Exception {
		super.validateEntity(entity);
		
		if (entity.getOhLohTags() != null) {
			for (OhLohTagEntity tag : entity.getOhLohTags()) {
				OhLohTagEntity already = tagRepository.findByName(tag.getName());
				
				if (already != null) {
					tag.setId(already.getId());
				}
			}
		}
		
		if (entity.getOhLohLicenses() != null) {
			for (OhLohLicenseEntity license : entity.getOhLohLicenses()) {
				OhLohLicenseEntity already = licenseRepository.findByName(license.getName());
				
				if (already != null) {
					license.setId(already.getId());
				}
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
