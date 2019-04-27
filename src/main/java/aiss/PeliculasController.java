package aiss;

import java.io.IOException;
import java.util.List;
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
 * Servlet implementation class PeliculasController
 */
public class PeliculasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(PeliculasController.class.getName());

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeliculasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		RequestDispatcher rd = null;
		
		TMDBSearchResource tmdb = new TMDBSearchResource();
		
		SearchMovie pelPorNombre = tmdb.getMovieByName(name);
		
		List<Result> result = pelPorNombre.getResults();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
