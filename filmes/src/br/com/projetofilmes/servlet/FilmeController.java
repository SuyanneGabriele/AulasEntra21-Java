package br.com.projetofilmes.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetofilmes.beans.Filme;
import br.com.projetofilmes.model.FilmeModel;

@WebServlet("/filmes")
public class FilmeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private FilmeModel filmeModel = new FilmeModel();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	switch (request.getParameter("action")) {
		case "listafilmes":
			listafilmesAction(request, response);
			break;
			
		case "addFilme":
			addFilmeAction(request, response);
			break;
		
		case "editFilme":
			editFilmeAction(request, response);
			break;
		
		case "deleteFilme":
			delFilmeAction(request, response);
			break;
		
		case "sobreFilme":
			sobreFilmeAction(request, response);
			break;

		default:
			break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String classificacao = request.getParameter("classificacao");
		String genero = request.getParameter("genero");
		String topFilme = request.getParameter("top_filme");
		Integer id = Integer.parseInt(request.getParameter("id"));
		int retorno = 0;
		
		Filme filmeSubmit = new Filme();
		filmeSubmit.setTitulo(titulo);
		filmeSubmit.setClassificacao(classificacao);
		filmeSubmit.setGenero(genero);
		filmeSubmit.setTopFilme(topFilme);
		
		if(id != null) {
			filmeSubmit.setId(id);
			retorno = FilmeModel.editarFilme(filmeSubmit);
		} 
		
		PrintWriter out = response.getWriter();
		if(retorno > 0) {		
			out.println("<body>");
			out.println("<b>Filme " + titulo + " alterado com Sucesso!</b>");
			out.println("<a href='filmes?action=listafilmes'>Voltar</a>");
			out.println("</body>");
		} else {
			out.println("<body>");
			out.println("<b>Ocorreu um erro, não foi possível adicinar o filme!</b>");
			out.println("<a href='filmes?action=listafilmes'>Voltar</a>");
			out.println("</body>");
		}
	}
	
	
	private void sobreFilmeAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt("id");
		Filme filme = filmeModel.getFilmeById(id);
		
		request.setAttribute("objFilme", filme);
		RequestDispatcher rd = request.getRequestDispatcher("sobreFilmeAction.jsp");
		rd.forward(request, response);
	}

	private void delFilmeAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (FilmeModel.delFilme(id) > 0) {
			response.getWriter().print("Deletado");
		} else {
			response.getWriter().print("Erro ao tentar deletar");
		}
		
	}

	private void editFilmeAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Filme filme = filmeModel.getFilmeById(id);

		request.setAttribute("objFilme", filme);
		RequestDispatcher rd = request.getRequestDispatcher("editFilmeAction.jsp");
        rd.forward(request, response);
	}


	private void addFilmeAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("addFilmeAction.jsp");
        rd.forward(request, response);		
	}

	private void listafilmesAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Filme> objListaFilmes = new ArrayList<Filme>();
		objListaFilmes = filmeModel.listaFilmes();

		request.setAttribute("listaFilmes", objListaFilmes);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	
}
