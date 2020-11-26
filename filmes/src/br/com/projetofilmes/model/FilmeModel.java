package br.com.projetofilmes.model;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.projetofilmes.beans.Filme;
import br.com.projetofilmes.dao.FilmesDAO;

public class FilmeModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Filme> listaFilmes() {
		return FilmesDAO.listaFilmes();
	}

	public Filme getFilmeById(int id) {
		
		return FilmesDAO.getFilmeById(id);
	}
	
	public int cadastraFilme(Filme filmeSubmit) {
		return FilmesDAO.cadastraFilme(filmeSubmit);
	}
	
	public static int editarFilme(Filme filmeSubmit) {
		return FilmesDAO.editarFilme(filmeSubmit);
	}

	public static int delFilme(int id) {
		return FilmesDAO.delFilme(id);
	}

}
