package br.com.crudfilmes.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crudfilmes.beans.Filme;
import br.com.crudfilmes.model.FilmeModel;

@WebServlet("/filme")
public class FilmeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmeModel filmeModel = new FilmeModel();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getParameter("action")) {
		case "listafilmes":
			listaFilmesAction(request, response);
			break;

		case "sobreFilme":
			sobreFilmeAction(request, response);
			break;

		case "cadFilme":
			cadFilmeAction(request, response);
			break;

		case "editFilme":
			editFilmeAction(request, response);
			break;

		case "delFilme":
			delFilmeAction(request, response);
			break;

		default:
			
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void delFilmeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void editFilmeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void cadFilmeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void sobreFilmeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void listaFilmesAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Filme> objListaFilme = new ArrayList<Filme>();
		objListaFilme = FilmeModel.listafilmes();
		
		request.setAttribute("listafilmes", objListaFilme);
		RequestDispatcher rd = request.getRequestDispatcher("listaFilmesAction.jsp");
		rd.forward(request, response);
	}

}
