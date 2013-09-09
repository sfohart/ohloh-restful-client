package br.ufba.dcc.mestrado.computacao.service;

import java.util.List;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;

public interface OhLohProjectService extends BaseOhLohService<OhLohProjectDTO, Long, OhLohProjectEntity>{

	public Long countAll();
	
	public OhLohProjectEntity findById(Long id);
	
	public List<OhLohProjectEntity> findAll(Integer startAt, Integer offset);

	public abstract void reloadTagsFromDatabase(OhLohProjectEntity entity);

	public abstract void reloadLicensesFromDatabase(OhLohProjectEntity entity);

	public abstract void reloadAnalysisFromDatabase(OhLohProjectEntity entity);
	
}
