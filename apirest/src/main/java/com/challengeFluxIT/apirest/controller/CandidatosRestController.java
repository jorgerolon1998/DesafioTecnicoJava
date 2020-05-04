package com.challengeFluxIT.apirest.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challengeFluxIT.apirest.entity.Candidato;
import com.challengeFluxIT.apirest.filter.CandidatoFilter;
import com.challengeFluxIT.apirest.filter.PageOptions;
import com.challengeFluxIT.apirest.filter.ResultPage;
import com.challengeFluxIT.apirest.filter.TableResult;
import com.challengeFluxIT.apirest.service.CandidatoService;
@RestController
@RequestMapping("/api")

public class CandidatosRestController {
	
	@Autowired
	private CandidatoService candidatoService;

	    
    private static final Logger logger = LoggerFactory.getLogger(CandidatosRestController.class);
    
    

	@GetMapping("/candidatos")
	public List<Candidato> findAll(){
		return candidatoService.findAll();
	}
	
	@GetMapping("/candidatosP")
    public ResponseEntity<TableResult<Candidato>> getCandidatos(
            @ModelAttribute(binding = false) PageOptions pageOptions,
            @ModelAttribute(binding = false) CandidatoFilter filter) {
        ResultPage<Candidato> resultPage = candidatoService.getCandidatos(filter, pageOptions);
       TableResult<Candidato> uiResult = TableResult.fromResultPage(resultPage);
        return ResponseEntity.ok(uiResult);
    }
	
    
    @DeleteMapping("/candidatos/delete/{id:\\d+}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long idCandidato) {
        logger.debug("delete");
        candidatoService.deleteById(idCandidato);
        return ResponseEntity.noContent().build();

    }
    
    @Transactional
    @PostMapping("/candidatos/add")
    public ResponseEntity<?> addCandidato(@RequestBody Candidato candidato) {
        logger.debug("post");
        candidatoService.save(candidato);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/candidatos/update")
    public ResponseEntity<?> put(@RequestBody Candidato candidato) {
        logger.debug("put");
        candidatoService.save(candidato);
        return ResponseEntity.noContent().build();
    }
    
	@GetMapping("/getCandidato/{candidatoId}")
	public Candidato getCandidatoById(@PathVariable long candidatoId){
		Candidato candidato = candidatoService.findById(candidatoId);
		
		if(candidato == null) {
			throw new RuntimeException("Candidato id not found -"+candidatoId);
		}
		return candidato;
	}

	
}