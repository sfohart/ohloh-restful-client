package br.ufba.dcc.mestrado.computacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import br.ufba.dcc.mestrado.computacao.ohloh.data.stack.OhLohStackDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.account.OhLohAccountEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.stack.OhLohStackEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohAccountRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohStackRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohStackServiceQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohAccountRepository;
import br.ufba.dcc.mestrado.computacao.repository.OhLohStackRepository;
import br.ufba.dcc.mestrado.computacao.service.OhLohStackService;

@OhLohStackServiceQualifier
public class OhLohStackServiceImpl extends BaseOhLohServiceImpl<OhLohStackDTO, OhLohStackEntity>
		implements OhLohStackService {

	public OhLohStackServiceImpl() {
		super(OhLohStackDTO.class, OhLohStackEntity.class);
	}

	@Inject
	@OhLohStackRepositoryQualifier
	private OhLohStackRepository stackRepository;
	
	@Inject
	@OhLohAccountRepositoryQualifier 
	private OhLohAccountRepository accountRepository;
	

	
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
	protected void validateEntity(OhLohStackEntity entity) throws Exception {		
		super.validateEntity(entity);
		
		if (entity != null) {
			OhLohAccountEntity account = entity.getAccount();
			
			if (account != null && account.getId() != null) {
				account = accountRepository.findById(account.getId());
				
				if (account == null) {					
					accountRepository.save(account);
				}
				
				entity.setAccount(account);
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
