package com.challengeFluxIT.apirest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.challengeFluxIT.apirest.entity.Candidato;
import com.challengeFluxIT.apirest.filter.CandidatoFilter;
import com.challengeFluxIT.apirest.filter.Filter;
import com.challengeFluxIT.apirest.filter.PageOptions;
import com.challengeFluxIT.apirest.filter.ResultPage;


@Repository
public class CandidatoDAOImpl implements CandidatoDAO{
	
	@PersistenceContext
	
    private EntityManager entityManager;
    
	
    @Override
    public long count(CandidatoFilter filter) {
        long count = 0L;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Candidato> entityRoot = query.from(Candidato.class);
        query.select(cb.count(entityRoot));
        if (filter != null) {
            filter.populateCriteriaQueryForCount(query, entityRoot, cb);
        }
        count = entityManager.createQuery(query).getSingleResult();
        return count;
    }

	@Override
	public List<Candidato> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Candidato> theQuery = currentSession.createQuery("from Candidato", Candidato.class);
		
		List<Candidato> candidatos = theQuery.getResultList();
		
		return candidatos;

	}
	@Override
	public void save(Candidato candidato) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(candidato);	
		
	}
	@Override
	@Transactional
	public void deleteById(long id) {
		Session currentSession = entityManager.unwrap(Session.class);

		@SuppressWarnings("unchecked")
		Query<Candidato> theQuery = currentSession.createQuery("delete from Candidato where id=:idCandidato");
		
		theQuery.setParameter("idCandidato", id);
		theQuery.executeUpdate();
		
	}
	
	@Override
	public Candidato findById(long id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Candidato candidato = currentSession.get(Candidato.class, id);
		
		return candidato;
	}


	@Override
	public ResultPage<Candidato> get(CandidatoFilter filter, PageOptions pageOpts) {
        CriteriaBuilder critBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Candidato> query = critBuilder.createQuery(Candidato.class);
        Root<Candidato> entityRoot = query.from(Candidato.class);
        query.select(entityRoot);
        if (filter != null) {
            filter.populateCriteriaQuery(query, entityRoot, critBuilder);
        }
        TypedQuery<Candidato> tQuery = entityManager.createQuery(query);
        if (pageOpts != null) {
            tQuery.setMaxResults(pageOpts.getMaxResults());
            tQuery.setFirstResult(pageOpts.getFirstResult());
        }
        List<Candidato> results = tQuery.getResultList();
        long total = pageOpts != null ? this.count(filter) : results.size();
        ResultPage<Candidato> resultPage = new ResultPage<Candidato>();
        resultPage.setItems(results);
        resultPage.setPage(pageOpts);
        resultPage.setTotal(total);
        return resultPage;
	}

}
