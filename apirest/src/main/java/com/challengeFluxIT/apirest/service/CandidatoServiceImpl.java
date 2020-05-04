package com.challengeFluxIT.apirest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengeFluxIT.apirest.dao.CandidatoDAO;
import com.challengeFluxIT.apirest.entity.Candidato;
import com.challengeFluxIT.apirest.filter.CandidatoFilter;
import com.challengeFluxIT.apirest.filter.PageOptions;
import com.challengeFluxIT.apirest.filter.ResultPage;

@Service
public class CandidatoServiceImpl implements CandidatoService{
	
    @Autowired
    private CandidatoDAO dao;
    
    private static final Logger logger = LoggerFactory.getLogger(CandidatoServiceImpl.class);



	@Override
	public Candidato findById(long id) {
        logger.trace("Busqueda de candidato por id");
		Candidato candidato = dao.findById(id);
		return candidato;
	}
	
	
	@Override
	public List<Candidato> findAll() {
        logger.trace("busqueda de todos los candidatos sin filtro");
		List<Candidato> listCandidatos= dao.findAll();
		return listCandidatos;
	}

	@Override
	public void save(Candidato candidato) {
        logger.trace("guardar candidato");
		dao.save(candidato);

	}

	@Override
	public void deleteById(long id) {
        logger.trace("eliminar candidato");
		dao.deleteById(id);
	}
	
    @Override
    public ResultPage<Candidato> getCandidatos(CandidatoFilter filter, PageOptions pageOptions) {
        logger.trace("getCandidatosPaginados");
        return this.dao.get(filter, pageOptions);
    }	

}
