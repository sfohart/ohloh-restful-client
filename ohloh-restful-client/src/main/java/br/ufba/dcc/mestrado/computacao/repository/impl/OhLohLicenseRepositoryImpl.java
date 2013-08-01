package br.ufba.dcc.mestrado.computacao.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.ufba.dcc.mestrado.computacao.ohloh.entities.project.OhLohLicenseEntity;
import br.ufba.dcc.mestrado.computacao.qualifier.OhLohLicenseRepositoryQualifier;
import br.ufba.dcc.mestrado.computacao.repository.OhLohLicenseRepository;

@OhLohLicenseRepositoryQualifier
public class OhLohLicenseRepositoryImpl extends BaseRepositoryImpl<OhLohLicenseEntity>
		implements OhLohLicenseRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801826722021443632L;

	public OhLohLicenseRepositoryImpl() {
		super(OhLohLicenseEntity.class);
	}

	@Override
	public OhLohLicenseEntity findByName(String name) {
		CriteriaBuilder criteriaBuilder = getEntityManager()
				.getCriteriaBuilder();
		CriteriaQuery<OhLohLicenseEntity> criteriaQuery = criteriaBuilder
				.createQuery(getEntityClass());

		Root<OhLohLicenseEntity> root = criteriaQuery.from(getEntityClass());
		CriteriaQuery<OhLohLicenseEntity> select = criteriaQuery.select(root);

		Predicate namePredicate = criteriaBuilder.equal(root.get("name"), name);
		select.where(namePredicate);

		TypedQuery<OhLohLicenseEntity> query = getEntityManager().createQuery(
				criteriaQuery);

		OhLohLicenseEntity result = null;

		try {
			result = query.getSingleResult();
		} catch (NoResultException ex) {

		} catch (NonUniqueResultException ex) {

		}

		return result;
	}
}
