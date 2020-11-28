package br.com.crudfilmes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.crudfilmes.beans.Filme;
import br.com.crudfilmes.cnn.ConnectionFactory;

public class FilmesDAO {

	public static ArrayList<Filme> listaFilmes() {
		Connection cnn = ConnectionFactory.getConnection();
		String query = "SELECT * FROM filmesdb";
		ArrayList<Filme> arFilmes = new ArrayList();

		try {
			PreparedStatement pStm = cnn.prepareStatement(query);
			ResultSet rsFilme = pStm.executeQuery();

			while (rsFilme.next()) {
				Filme filme = new Filme(rsFilme.getInt("id"), rsFilme.getString("titulo"),
						rsFilme.getString("classificacao"), rsFilme.getString("genero"),
						rsFilme.getString("top_filme"));
				arFilmes.add(filme);
			}
			cnn.close();
			rsFilme.close();
			return arFilmes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int cadastrarFilme(Filme objFilme) {
		return 1;
	}
	
	public static Filme getFilmeById(int id) {
	Filme filmeRetorno = new Filme();
	String query = "SELECT * FROM filmes WHERE id = ?";
	Connection cnn = ConnectionFactory.getConnection();
		try {
			PreparedStatement pStm = cnn.prepareStatement(query);
			pStm.setInt(1, id);
			ResultSet rsFilme = pStm.executeQuery();
			
			while (rsFilme.next()) {
				filmeRetorno.setId(id);
				filmeRetorno.setTitulo("titulo");
				filmeRetorno.setClassificacao("classificacao");
				filmeRetorno.setGenero("genero");
				filmeRetorno.setTopFilme("top_filme");
			}
			rsFilme.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmeRetorno;
	}
	
	public static int cadFilme(Filme filmeSubmit) {
		String query = "INSERT INTO filmes (titulo, classificacao, genero, top_filme) VALUES (?, ?, ?, ?)";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;
		
		try {
			PreparedStatement pStm = cnn.prepareStatement(query);
			pStm.setString(1, filmeSubmit.getTitulo());
			pStm.setString(2, filmeSubmit.getClassificacao());
			pStm.setString(3, filmeSubmit.getGenero());
			pStm.setString(4, filmeSubmit.getTopFilme());
			linhasAfetadas = pStm.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}
	
	public static int editFilme(Filme filmeSubmit) {
		String query = "UPDATE filmes SET titulo = ?, classificacao = ?, genero = ?, top_filme = ?";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;
		
		try {
			PreparedStatement pStm = cnn.prepareStatement(query);
			pStm.setString(1, filmeSubmit.getTitulo());
			pStm.setString(2, filmeSubmit.getClassificacao());
			pStm.setString(3, filmeSubmit.getGenero());
			pStm.setString(4, filmeSubmit.getTopFilme());
			linhasAfetadas = pStm.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}
	
	public static int delFilme(int id) {
		String query = "DELETE * FROM filmes WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;
		
		try {
			PreparedStatement pStm = cnn.prepareStatement(query);
			pStm.setInt(1, id);
			linhasAfetadas = pStm.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}
}
