package br.com.projetofilmes.dao;

import java.sql.*;
import java.util.ArrayList;
import br.com.projetofilmes.beans.Filme;
import br.com.projetofilmes.cnn.ConnectionFactory;

public class FilmesDAO {

	public static ArrayList<Filme> listaFilmes() {
		Connection cnn = ConnectionFactory.getConnection();
		String query = "SELECT * FROM filmes";
		ArrayList<Filme> arFilmes = new ArrayList();

		try {
			PreparedStatement pStm = cnn.prepareStatement(query);
			ResultSet rsFilmes = pStm.executeQuery();

			while (rsFilmes.next()) {
				Filme filme = new Filme(rsFilmes.getInt("id"), rsFilmes.getString("titulo"),
						rsFilmes.getString("classificacao"), rsFilmes.getString("genero"),
						rsFilmes.getString("top_filmes"));
				arFilmes.add(filme);
			}
			cnn.close();
			rsFilmes.close();
			return arFilmes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
				filmeRetorno.setGenero("genero");
				filmeRetorno.setClassificacao("classificacao");
				filmeRetorno.setTopFilme("top_filme");
			}
			rsFilme.close();
			cnn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmeRetorno;
	}
	
	public static int cadastraFilme(Filme filmeSubmit) {
		String query = "INSERT INTO filmes (titulo, classificacao, genero, top_filme) VALUES (?, ?, ?, ?)";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;
		
		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setString(1, filmeSubmit.getTitulo());
			pStmt.setString(2, filmeSubmit.getClassificacao());
			pStmt.setString(3, filmeSubmit.getGenero());
			pStmt.setString(3, filmeSubmit.getTopFilme());
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;

	}
	
	public static int editarFilme(Filme filmeSubmit) {
		String query = "UPDATE filmes SET titulo = ?, classificacao = ?, genero = ?, top_filme = ? WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;
		
		try {
			PreparedStatement pStm = cnn.prepareStatement(query);
			pStm.setString(1, filmeSubmit.getTitulo());
			pStm.setString(2, filmeSubmit.getClassificacao());
			pStm.setString(3, filmeSubmit.getGenero());
			pStm.setString(4, filmeSubmit.getTopFilme());
			pStm.setInt(5, filmeSubmit.getId());
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
