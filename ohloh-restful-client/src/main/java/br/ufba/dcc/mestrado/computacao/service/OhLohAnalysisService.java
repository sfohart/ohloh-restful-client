package br.ufba.dcc.mestrado.computacao.service;

import java.util.List;

import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysisDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisEntity;

public interface OhLohAnalysisService extends BaseOhLohService<OhLohAnalysisDTO, OhLohAnalysisEntity>{

	public Long countAll();
	
	public OhLohAnalysisEntity findById(Long id);
	
	public List<OhLohAnalysisEntity> findAll(Integer startAt, Integer offset);
	
}
