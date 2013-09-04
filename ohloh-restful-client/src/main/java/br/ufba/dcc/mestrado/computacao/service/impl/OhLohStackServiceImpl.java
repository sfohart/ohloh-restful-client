package br.ufba.dcc.mestrado.computacao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.stack.OhLohStackDTO;
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

	public OhLohStackServiceImpl() {
		super(OhLohStackDTO.class, OhLohStackEntity.class);
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
			List<OhLohTagEntity> totalTagList = new ArrayList<>();
			
			for (OhLohStackEntryEntity stackEntry : entity.getOhLohStackEntries()) {
				if (stackEntry.getProjectId() != null) {
					OhLohProjectEntity project = projectService.findById(stackEntry.getProjectId());
					
					if (project == null) {
						OhLohProjectDTO projectDTO = restfulClient.getProject(stackEntry.getProjectId().toString(), request);
						project = projectService.buildEntity(projectDTO);
						projectService.validateEntity(project);
				
						if (project != null && project.getOhLohTags() != null) {
							totalTagList.addAll(project.getOhLohTags());
						}
						
						stackEntry.setProject(project);
					}
				}
			}
			
			for (OhLohStackEntryEntity stackEntry : entity.getOhLohStackEntries()) {
				if (stackEntry.getProject() != null && stackEntry.getProject().getOhLohTags() != null) {
					
					List<OhLohTagEntity> projectTagList = new ArrayList<>();
					
					for (OhLohTagEntity tag : stackEntry.getProject().getOhLohTags()) {
						if (totalTagList.contains(tag)) {
							int indexOf = totalTagList.indexOf(tag);
							projectTagList.add(totalTagList.get(indexOf));
						}
					}
					
					stackEntry.getProject().getOhLohTags().clear();
					stackEntry.getProject().getOhLohTags().addAll(projectTagList);
				}				
			}
			
		}
		
		
		
	}
	
	@Override
	public OhLohStackEntity store(OhLohStackDTO dto) throws Exception{
		OhLohStackEntity entity = super.store(dto);
		stackRepository.save(entity);
		return entity;
	}

}
