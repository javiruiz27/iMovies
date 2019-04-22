package aiss;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.TMDBSearchResource;
import aiss.model.tmdb.Details;
import aiss.model.tmdb.Result;
import aiss.model.tmdb.SearchMovie;

/**
 * Servlet implementation class InfoController
 */
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(InfoController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;

		TMDBSearchResource tmdb = new TMDBSearchResource();

		String titulo = request.getParameter("titulo");
		String id = request.getParameter("id");

		Integer id2 = Integer.parseInt(id);

		Details detalles = tmdb.getDetalles(id2);
		String overview = detalles.getOverview();
		String title = detalles.getTitle();
		String fecha = detalles.getReleaseDate();
		Double puntuacion = detalles.getVoteAverage();

		rd = request.getRequestDispatcher("/infoPeliculas.jsp");
		request.setAttribute("overview", overview);
		request.setAttribute("titulo", title);
		request.setAttribute("fechaEstreno", fecha);
		request.setAttribute("puntuacion", puntuacion);

		log.log(Level.INFO, "Mostrando información detallada de: " + titulo + "con id: " + id);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
