package aiss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.TMDBSearchResource;
import aiss.model.tmdb.Result;
import aiss.model.tmdb.SearchMovie;

/**
 * Servlet implementation class PeliculasActualesSearchController
 */
public class PeliculasActualesSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(PeliculasActualesSearchController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PeliculasActualesSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;

		TMDBSearchResource tmdb = new TMDBSearchResource();

		SearchMovie cartelera = tmdb.getCartelera();

		List<Result> pelActuales = cartelera.getResults();

		String actuales = "si";

		List<Result> pelActualesPunt = sacaPelPuntMayor(pelActuales, 3.0);

		if (pelActualesPunt.size() > 0) {
			rd = request.getRequestDispatcher("/peliculasActuales.jsp");
			request.setAttribute("pelActuales", pelActualesPunt);
			request.setAttribute("actuales", actuales);

			log.log(Level.INFO, "Se han cargado las películas actuales.");

		} else {
			log.log(Level.INFO, "Ha ocurrido un fallo al cargar las películas actuales.");
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

	private List<Result> sacaPelPuntMayor(List<Result> pelActuales, Double punt) {
		List<Result> res = new ArrayList<Result>();
		for (Result r : pelActuales) {
			if (r.getVoteAverage() > punt) {
				res.add(r);
			}
		}
		return res;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
