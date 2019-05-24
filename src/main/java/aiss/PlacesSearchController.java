package aiss;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.places.Result;
import aiss.model.places.Search;
import aiss.model.resource.PlacesSearchResource;
import aiss.model.resource.WeatherSearchResource;
import aiss.model.weather.SearchWeather;
import aiss.model.weather.Weather;

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
		
		WeatherSearchResource items= new WeatherSearchResource();
		
		SearchWeather weather = items.getWeather(lugar);
		
		List<aiss.model.weather.List> tiempo = weather.getList();
		
		
		
	//	List<Weather> descripcion = tiempo.stream().map(x->x.getWeather()).collect(Collectors.toList());
		
//		for (int i = 0; i < tiempo.size(); i++) {
//			for (int j = 0; i < tiempo.size(); j++) {
//			 descripcion.add(tiempo.get(i).getWeather().get(j));
//			
//		}
//		}
			
		
		
		Search cines = places.getPlaces(lugar);
	   
	
		Date dNow = new Date();
		   SimpleDateFormat ft =  new SimpleDateFormat ("MM/dd/yyyy HH:mm");
		   Calendar calendar = Calendar.getInstance();
		   calendar.setTime(dNow); //tuFechaBase es un Date;
		 
		   List<String> fechas = new ArrayList<>();
		  
			for (int i = 0; i < tiempo.size(); i++) {
				 calendar.add(Calendar.HOUR,   3); 
				 Date fechaSalida = calendar.getTime();
				 String fechaFormateada = ft.format(fechaSalida);
				 
				 fechas.add(fechaFormateada);
				
			}	
			
			
		

		List<Result> result = cines.getResults();

		if ( result.size() > 0 && tiempo.size()>0) {
			rd = request.getRequestDispatcher("/listadoCines.jsp");
			request.setAttribute("lugar", lugar);
			request.setAttribute("cines", result);
			request.setAttribute("tiempo", tiempo);
			request.setAttribute("fechas", fechas);
//			request.setAttribute("descripcion", descripcion);
			log.log(Level.INFO, "Se han cargado los cines y el tiempo de " + lugar);
		} else {
			log.log(Level.INFO, "Ha ocurrido un error al cargar los cines o el timepo  de " + lugar);
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
