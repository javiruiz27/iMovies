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
import aiss.model.tmdb.Result2;
import aiss.model.tmdb.SearchVideo;



/**
 * Servlet implementation class SearchMoviesController
 */
public class SearchMoviesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SearchMoviesController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMoviesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String titulo = request.getParameter("titulo");
		String id = request.getParameter("id");
		
		int nuevo = Integer.parseInt(id);
		
		RequestDispatcher rd = null;	
		
		TMDBSearchResource tmdb = new TMDBSearchResource();		
		
		SearchVideo v = tmdb.getVideo(nuevo);
		Details detalles = tmdb.getDetalles(nuevo);	
		
		String sinopsis = detalles.getOverview();
		String fechaEstreno = detalles.getReleaseDate();
		
		List<Result2> listita = v.getResults();
		
		String url = listita.get(0).getKey();
		
		
		
				

		if (url!=null || url==""){
			rd = request.getRequestDispatcher("/informacion.jsp");
			request.setAttribute("url", url);	
			request.setAttribute("titulo", titulo);
			request.setAttribute("id", id);
			request.setAttribute("sinopsis", sinopsis);
			request.setAttribute("fechaEstreno", fechaEstreno);
			log.log(Level.INFO, "Mostrando información detallada de: "+titulo);
		} else {
			
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
