package aiss;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.WeatherResource;
import aiss.model.weather.SearchLocationKey;
import aiss.model.weather.SearchWeather;

/**
 * Servlet implementation class WeatherSearchControlller
 */
public class WeatherSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(WeatherSearchController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherSearchController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ciudad = request.getParameter("ciudad");
		
		RequestDispatcher rd=null;
		
		WeatherResource weather = new WeatherResource();
		
		SearchLocationKey locationKey = weather.getLocationKey(ciudad);
		
		if(locationKey.getKey()!=null) {
		SearchWeather tiempo = weather.getTiempo(locationKey.getKey());
		log.log(Level.INFO, "Se ha  obtenido sin pronlemas la locationKey de " + ciudad);
		if(tiempo!=null) {
			rd= request.getRequestDispatcher("/listadoCines.jsp");
			request.setAttribute("tiempo", tiempo);
			log.log(Level.INFO, "Se ha cargado el tiempo de " + ciudad+ "con existo");
		}else {
			log.log(Level.INFO, "Ha ocurrido un error al cargar el tiempo de " + ciudad);
			rd = request.getRequestDispatcher("/error.jsp");
			
		}
		
			
		}else {
			log.log(Level.INFO, "Ha ocurrido un error al obtener la locationKey de " + ciudad);
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
