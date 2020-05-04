package com.challengeFluxIT.apirest.filter;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.challengeFluxIT.apirest.entity.Candidato;

public class CandidatoFilter extends AbstractFilter<Candidato> {

    private String nombre;
    
    private String apellido;
    
    private Integer documento;
    


	@Override
	protected void populatePredicates(List<Predicate> predicates, Root<Candidato> root, CriteriaBuilder critBuilder) {
		// TODO Auto-generated method stub
		
	}

}
