package aiss.model.resource;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.places.Search;
import aiss.model.weather.SearchWeather;

public class WeatherSearchResource {

	private static final String WEATHER_API_KEY = "4812afad37956a4a23bc9cd4e9878b7c";
	private static final Logger log = Logger.getLogger(WeatherSearchResource.class.getName());
//http://api.openweathermap.org/data/2.5/forecast?q=Sevilla&units=metric&lang=es&appid=4812afad37956a4a23bc9cd4e9878b7c
	public SearchWeather getWeather(String Ciudad) throws UnsupportedEncodingException {
		 String url = "http://api.openweathermap.org/data/2.5/forecast?q="+URLEncoder.encode(Ciudad, "UTF-8")+"&units=metric"+"&lang=es"+"&appid="+WEATHER_API_KEY;
			
		ClientResource cr = new ClientResource(url);
		SearchWeather result = cr.get(SearchWeather.class);

		return result;

	}
	
	
	
	
	

}
