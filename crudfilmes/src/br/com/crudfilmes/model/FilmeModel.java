package br.com.crudfilmes.model;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.crudfilmes.beans.Filme;
import br.com.crudfilmes.dao.FilmesDAO;

public class FilmeModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<Filme> listafilmes() {
		return FilmesDAO.listaFilmes();
	}

	public Filme getFilmeById(int id) {
		return FilmesDAO.getFilmeById(id);
	}
	
	public static int cadFilme(Filme filmeSubmit) {
		return FilmesDAO.cadFilme(filmeSubmit);
	}
	
	public static int editFilme(Filme filmeSubmit) {
		return FilmesDAO.editFilme(filmeSubmit);
	}
	
	public static int delFilme(int id) {
		return FilmesDAO.delFilme(id);
	}
}