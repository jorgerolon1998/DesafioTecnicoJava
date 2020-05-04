package com.challengeFluxIT.apirest.service;

import java.util.List;


import com.challengeFluxIT.apirest.entity.Candidato;
import com.challengeFluxIT.apirest.filter.CandidatoFilter;
import com.challengeFluxIT.apirest.filter.PageOptions;
import com.challengeFluxIT.apirest.filter.ResultPage;


public interface CandidatoService {
	
	public List<Candidato> findAll();
    
	public void save(Candidato candidato);
	
	public void deleteById(long id);
	
	public Candidato findById(long id);
	
    public ResultPage<Candidato> getCandidatos(CandidatoFilter filter, PageOptions pageOptions);


	
}
