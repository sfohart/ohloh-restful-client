package br.ufba.dcc.mestrado.computacao.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.stack.OhLohStackDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohLicenseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohTagEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.stack.OhLohStackEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.stack.OhLohStackEntryEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.client.OhLohRestfulClient;
import br.ufba.dcc.mestrado.computacao.ohloh.restful.request.OhLohBaseRequest;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohStackRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohProjectServiceQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohStackServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohStackRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohProjectService;
import br.ufba.dcc.mestrado.computacao.service.OhLohStackService;

@OhLohStackServiceQualifier
public class OhLohStackServiceImpl extends BaseOhLohServiceImpl<OhLohStackDTO, Long, OhLohStackEntity>
		implements OhLohStackService {
	
	protected Logger logger = Logger.getLogger(OhLohStackServiceImpl.class.getName());

	@Inject
	public OhLohStackServiceImpl(@OhLohStackRepositoryQualifier OhLohStackRepository repository) {
		super(repository, OhLohStackDTO.class, OhLohStackEntity.class);
	}

	@Inject
	@OhLohStackRepositoryQualifier
	private OhLohStackRepository stackRepository;
	
	@Inject
	@OhLohProjectServiceQualifier
	private OhLohProjectService projectService;
	
	@Inject
	private OhLohRestfulClient restfulClient;
	
	public Long countAll() {
		return stackRepository.countAll();
	}
	
	public OhLohStackEntity findById(Long id) {
		return stackRepository.findById(id);
	}
	
	public List<OhLohStackEntity> findAll(Integer startAt, Integer offset) {
		return stackRepository.findAll(startAt, offset);
	}
	
	@Override
	public void validateEntity(OhLohStackEntity entity) throws Exception {
		super.validateEntity(entity);
		
		OhLohBaseRequest request  = new OhLohBaseRequest();
		
		if (entity.getOhLohStackEntries() != null) {
			Map<String, OhLohTagEntity> tagMap = new HashMap<>();
			Map<String, OhLohLicenseEntity> licenseMap = new HashMap<>();
			
			for (OhLohStackEntryEntity stackEntry : entity.getOhLohStackEntries()) {
				if (stackEntry.getProjectId() != null) {
					OhLohProjectEntity project = projectService.findById(stackEntry.getProjectId());
					
					if (project == null) {
						OhLohProjectDTO projectDTO = restfulClient.getProject(stackEntry.getProjectId().toString(), request);
						if (projectDTO != null) {
							project = projectService.buildEntity(projectDTO);
							if (project != null) {
								projectService.validateEntity(project);
							}
						}
					}
					
					if (project != null) {
						if (project.getOhLohTags() != null) {
							for (OhLohTagEntity tag : project.getOhLohTags()) {
								tagMap.put(tag.getName(), tag);
							}
						}
						
						
						if (project.getOhLohLicenses() != null) {
							for (OhLohLicenseEntity license : project.getOhLohLicenses()) {
								licenseMap.put(license.getName(), license);
							}
						}
					}
					
					stackEntry.setProject(project);
				}
			}
			
			for (OhLohStackEntryEntity stackEntry : entity.getOhLohStackEntries()) {
				if (stackEntry.getProject() != null && stackEntry.getProject().getOhLohTags() != null) {
					
					List<OhLohTagEntity> projectTagList = new ArrayList<>();
					List<OhLohLicenseEntity> projectLicenseList = new ArrayList<>();
					
					for (OhLohTagEntity tag : stackEntry.getProject().getOhLohTags()) {
						projectTagList.add(tagMap.get(tag.getName()));						
					}
					
					for (OhLohLicenseEntity license : stackEntry.getProject().getOhLohLicenses()) {
						projectLicenseList.add(licenseMap.get(license.getName()));						
					}
					
					stackEntry.getProject().getOhLohTags().clear();
					stackEntry.getProject().getOhLohTags().addAll(projectTagList);
					
					
					stackEntry.getProject().getOhLohLicenses().clear();
					stackEntry.getProject().getOhLohLicenses().addAll(projectLicenseList);
				}				
			}
		}
	}
	
	@Override
	public OhLohStackEntity process(OhLohStackDTO dto) throws Exception{
		OhLohStackEntity entity = super.process(dto);
		
		if (entity != null && entity.getOhLohStackEntries() != null) {
			Iterator<OhLohStackEntryEntity> iterator = entity.getOhLohStackEntries().iterator();
			while(iterator.hasNext()) {
				OhLohStackEntryEntity stackEntry  = iterator.next();
				
				if (stackEntry.getProject() != null) {
					projectService.reloadTagsFromDatabase(stackEntry.getProject());
					projectService.reloadLicensesFromDatabase(stackEntry.getProject());
					projectService.reloadAnalysisFromDatabase(stackEntry.getProject());
					
					OhLohProjectEntity project = projectService.saveEntity(stackEntry.getProject());
					
					if (project != null) {
						stackEntry.setProject(project);
						stackEntry.setProjectId(project.getId());
						
						stackEntry.setOhLohStack(entity);
						stackEntry.setStackId(entity.getId());
					} else {
						iterator.remove();
						logger.error(String.format("stack entry %d project %d nao persistiu corretamente", stackEntry.getId(), stackEntry.getProjectId()));
					}
				} else if (stackEntry.getProject() == null || stackEntry.getOhLohStack() == null) {
					iterator.remove();
					logger.error(String.format("stack entry %d project %d nao persistiu corretamente", stackEntry.getId(), stackEntry.getProjectId()));
				}
			}
		}
		
		stackRepository.save(entity);
		return entity;
	}

}
