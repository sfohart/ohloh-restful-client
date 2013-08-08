package br.ufba.dcc.mestrado.computacao.service;

import br.ufba.dcc.mestrado.computacao.ohloh.data.project.OhLohProjectDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohProjectEntity;

public interface OhLohProjectService extends BaseOhLohService<OhLohProjectDTO, OhLohProjectEntity>{

	public Long countAll();
	
	public OhLohProjectEntity findById(Long id);
	
}
