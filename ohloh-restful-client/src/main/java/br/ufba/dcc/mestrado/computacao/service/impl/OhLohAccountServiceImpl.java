package br.ufba.dcc.mestrado.computacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import br.ufba.dcc.mestrado.computacao.ohloh.data.account.OhLohAccountDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.account.OhLohAccountEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohAccountRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohAccountServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAccountRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohAccountService;

@OhLohAccountServiceQualifier
public class OhLohAccountServiceImpl extends BaseOhLohServiceImpl<OhLohAccountDTO, OhLohAccountEntity>
		implements OhLohAccountService {

	public OhLohAccountServiceImpl() {
		super(OhLohAccountDTO.class, OhLohAccountEntity.class);
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
	public OhLohAccountEntity store(OhLohAccountDTO dto) throws Exception{
		OhLohAccountEntity entity = super.store(dto);
		accountRepository.save(entity);
		return entity;
	}

}
