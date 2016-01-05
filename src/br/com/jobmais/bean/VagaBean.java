package br.com.jobmais.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jobmais.dao.VagaDao;
import br.com.jobmais.modelo.Vaga;

@Named
@RequestScoped
public class VagaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private Vaga vaga = new Vaga();
	
	@Inject
	private VagaDao dao;
	
	private List<Vaga> vagas;
	private List<Vaga> todasAsVagas;
	
	public Vaga getVaga() {
		return vaga;
	}
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}




	public String adiciona(){
		vaga.setDataAnuncio(vaga.pegaDataAtual());
		dao.adicionaVaga(vaga);
		this.vagas = dao.listaVagas();
		this.todasAsVagas = dao.listaTodasAsVagas();
		System.out.println("Vaga adicionada com sucesso!");
		
		return "index?faces-redirect=true";
	}
	
	
	public String remove() {
		dao.remover(vaga);
		vagas = dao.listaVagas();
		todasAsVagas = dao.listaTodasAsVagas();
		System.out.println("removendo vaga");
		return "cadastro-vaga?faces-redirect=true";
	}
	
	public List<Vaga> getVagas(){
		this.vagas = dao.listaVagas();
		System.out.println("Listando Vagas");
		return vagas;
	}
	
	public List<Vaga> listaTodas() {
		todasAsVagas = dao.listaTodasAsVagas();
		System.out.println("Listando vagas por data anunciada");
		return todasAsVagas;
	}
	
	
	
	
	

}
