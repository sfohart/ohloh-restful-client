package br.ufba.dcc.mestrado.computacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import br.ufba.dcc.mestrado.computacao.ohloh.data.account.OhLohAccountDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.account.OhLohAccountEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.repository.OhLohAccountRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.service.OhLohAccountServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAccountRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohAccountService;

@OhLohAccountServiceQualifier
public class OhLohAccountServiceImpl extends BaseOhLohServiceImpl<OhLohAccountDTO, Long, OhLohAccountEntity>
		implements OhLohAccountService {

	@Inject
	public OhLohAccountServiceImpl(@OhLohAccountRepositoryQualifier OhLohAccountRepository repository) {
		super(repository, OhLohAccountDTO.class, OhLohAccountEntity.class);
	}

	@Inject
	@OhLohAccountRepositoryQualifier
	private OhLohAccountRepository accountRepository;
	

	
	public Long countAll() {
		return accountRepository.countAll();
	}
	
	public OhLohAccountEntity findById(Long id) {
		return accountRepository.findById(id);
	}
	
	public List<OhLohAccountEntity> findAll(Integer startAt, Integer offset) {
		return accountRepository.findAll(startAt, offset);
	}
	
	
	@Override
	public OhLohAccountEntity process(OhLohAccountDTO dto) throws Exception{
		OhLohAccountEntity entity = super.process(dto);
		accountRepository.save(entity);
		return entity;
	}

}
