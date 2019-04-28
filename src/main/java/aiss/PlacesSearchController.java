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

import aiss.model.places.Result;
import aiss.model.places.Search;
import aiss.model.resource.PlacesSearchResource;

/**
 * Servlet implementation class PlacesSearchController
 */
public class PlacesSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(PlacesSearchController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlacesSearchController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String lugar = request.getParameter("ciudad");
//https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=CnRtAAAATLZNl354RwP_9UKbQ_5Psy40texXePv4oAlgP4qNEkdIrkyse7rPXYGd9D_Uj1rVsQdWT4oRz4QrYAJNpFX7rzqqMlZw2h2E2y5IKMUZ7ouD_SlcHxYq1yL4KbKUv3qtWgTK0A6QbGh87GB3sscrHRIQiG2RrmU_jF4tENr9wGS_YxoUSSDrYjWmrNfeEHSGSc3FyhNLlBU&key=YOUR_API_KEY
		RequestDispatcher rd = null;

		PlacesSearchResource places = new PlacesSearchResource();

		Search cines = places.getPlaces(lugar);
		
		

		List<Result> result = cines.getResults();

		if ( result.size() > 0) {
			rd = request.getRequestDispatcher("/listadoCines.jsp");
			request.setAttribute("lugar", lugar);
			request.setAttribute("cines", result);
			log.log(Level.INFO, "Se han cargado los cines de " + lugar);
		} else {
			log.log(Level.INFO, "Ha ocurrido un error al cargar los cines de " + lugar);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);

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
