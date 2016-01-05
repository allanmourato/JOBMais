package br.com.jobmais.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.jobmais.modelo.Vaga;

@Stateless
public class VagaDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	public void adicionaVaga(Vaga vaga){
		this.manager.persist(vaga);
	}
	
	public void remover(Vaga vaga) {
		Vaga vagaParaRemover = this.manager.find(Vaga.class, vaga.getId());
		manager.remove(vagaParaRemover);
	}
	
	public List<Vaga> listaVagas(){
		return manager.createQuery("select v from Vaga v", Vaga.class).getResultList();
	}
	
	public List<Vaga> listaTodasAsVagas(){
		return manager.createQuery("select v from Vaga v order by v.dataAnuncio desc", Vaga.class).getResultList();
	}
	
	

}
