package com.challengeFluxIT.apirest.dao;

import java.util.List;

import com.challengeFluxIT.apirest.entity.Candidato;
import com.challengeFluxIT.apirest.filter.CandidatoFilter;
import com.challengeFluxIT.apirest.filter.Filter;
import com.challengeFluxIT.apirest.filter.PageOptions;
import com.challengeFluxIT.apirest.filter.ResultPage;


public interface CandidatoDAO {
		
	
	public void save(Candidato candidato);
	
	public void deleteById(long id);
        
	public List<Candidato> findAll();
	
	public Candidato findById(long id);
	
    long count(CandidatoFilter filter);

	
    public ResultPage<Candidato> get(CandidatoFilter filter, PageOptions pageOpts);







}
