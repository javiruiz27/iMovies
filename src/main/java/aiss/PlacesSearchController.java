package aiss;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

		String lugar = "hola";

		RequestDispatcher rd = null;
		if (request.getParameter("ciudad").length() != 0) {
			lugar = request.getParameter("ciudad");
		} else {
			rd = request.getRequestDispatcher("/index.jsp");

			log.log(Level.INFO, "Has dejado la ciudad en blanco");

		}

//https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=CnRtAAAATLZNl354RwP_9UKbQ_5Psy40texXePv4oAlgP4qNEkdIrkyse7rPXYGd9D_Uj1rVsQdWT4oRz4QrYAJNpFX7rzqqMlZw2h2E2y5IKMUZ7ouD_SlcHxYq1yL4KbKUv3qtWgTK0A6QbGh87GB3sscrHRIQiG2RrmU_jF4tENr9wGS_YxoUSSDrYjWmrNfeEHSGSc3FyhNLlBU&key=YOUR_API_KEY

		PlacesSearchResource places = new PlacesSearchResource();
		if (places.getPlaces(lugar).getResults().size() < 0) {
			rd = request.getRequestDispatcher("/error.jsp");
		} else {
			log.log(Level.FINE, "Aqui estamos: -----------------------------------------------------------");
			WeatherSearchResource items = new WeatherSearchResource();
			log.log(Level.FINE, "Aqui estamos: -----------------------------------------------------------" + items);
			SearchWeather weather = null;
			try {
			weather = items.getWeather(lugar);
			}catch(Exception e) {
				rd = request.getRequestDispatcher("/errorCiudad.jsp");
				rd.forward(request, response);
			}
			log.log(Level.FINE, "Aqui estamos: +++++++++++++++++++++++");
			if (weather == null || weather.getCity().getName().length() < 0 || weather.getList().isEmpty()) {
				log.log(Level.FINE, "Aqui estamos: --------------------------------" + weather);
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			} else {
				log.log(Level.FINE, "Ha pasado");
				List<aiss.model.weather.List> tiempo = weather.getList();

				List<Weather> weather2 = new ArrayList<>();
				List<String> description = new ArrayList<>();
				List<String> icon = new ArrayList<>();
				List<String> urls = new ArrayList<>();
				List<Double> temperatura = new ArrayList<>();

				for (int i = 0; i < tiempo.size(); i++) {
					aiss.model.weather.List list = tiempo.get(i);
					temperatura.add(tiempo.get(i).getMain().getTemp());

					for (int j = 0; j < tiempo.get(i).getWeather().size(); j++) {
						weather2.add(list.getWeather().get(j));

					}
				}

				for (int k = 0; k < weather2.size(); k++) {

					description.add(weather2.get(k).getDescription());
					icon.add(weather2.get(k).getIcon());
				}

				for (int z = 0; z < icon.size(); z++) {
					urls.add("https://openweathermap.org/themes/openweathermap/assets/vendor/owm/img/widgets/"
							+ icon.get(z) + ".png");

				}

				Date dNow = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy HH:mm");
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dNow); // tuFechaBase es un Date;

				List<String> fechas = new ArrayList<>();

				for (int i = 0; i < tiempo.size(); i++) {
					calendar.add(Calendar.HOUR, 3);
					Date fechaSalida = calendar.getTime();
					String fechaFormateada = ft.format(fechaSalida);

					fechas.add(fechaFormateada);

				}

				log.log(Level.FINE, "Aqui estamos: --------------------------------");
				Search cines = places.getPlaces(lugar);
				if (cines.getResults().size() < 0) {
					rd = request.getRequestDispatcher("/errorCiudad.jsp");

				} else {

					log.log(Level.FINE, "Aqui estamos: --------------------------------" + cines);

					List<String> urlCine = new ArrayList<>();
					List<Result> result = cines.getResults();
					log.log(Level.FINE, "Aqui estamos iwucniqjwnrcpiqjwnrv: --------------------------------" + cines);
					for (int x = 0; x < result.size(); x++) {
						urlCine.add("https://www.google.com/maps/search/" + "?api=1&query="
								+ result.get(x).getGeometry().getLocation().getLat() + ","
								+ result.get(x).getGeometry().getLocation().getLng());

					}

					if (result.size() > 0 && tiempo.size() > 0) {
						rd = request.getRequestDispatcher("/listadoCines.jsp");
						request.setAttribute("lugar", lugar);
						request.setAttribute("cines", result);
						request.setAttribute("tiempo", tiempo);
						request.setAttribute("fechas", fechas);
						request.setAttribute("weather2", weather2);
						request.setAttribute("description", description);
						request.setAttribute("urls", urls);
						request.setAttribute("urlCine", urlCine);
						request.setAttribute("temperatura", temperatura);
						log.log(Level.INFO, "Se han cargado los cines y el tiempo de " + lugar);
					} else {
						log.log(Level.INFO, "Ha ocurrido un error al cargar los cines o el timepo  de " + lugar);
						rd = request.getRequestDispatcher("/errorCiudad.jsp");
					}
					rd.forward(request, response);
				}
			}
		}
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