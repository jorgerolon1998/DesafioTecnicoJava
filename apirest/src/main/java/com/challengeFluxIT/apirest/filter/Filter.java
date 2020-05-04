package com.challengeFluxIT.apirest.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.challengeFluxIT.apirest.entity.Candidato;

public interface Filter<T> {
    void populateCriteriaQuery(CriteriaQuery<Candidato> query, Root<Candidato> entityRoot, CriteriaBuilder critBuilder);

    void populateCriteriaQueryForCount(CriteriaQuery<Long> query, Root<Candidato> root, CriteriaBuilder critBuilder);
}
