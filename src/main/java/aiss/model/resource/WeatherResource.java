package aiss.model.resource;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.weather.SearchLocationKey;
import aiss.model.weather.SearchWeather;

public class WeatherResource {

	private static final String Weather_API_KEY = "7brLnI5lLl0VZPvm9P6YRJbVqaIDSHzs";
	private static final Logger log = Logger.getLogger(WeatherResource.class.getName());

	public SearchLocationKey getLocationKey(String ciudad) throws UnsupportedEncodingException {
		String url = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey="+Weather_API_KEY+"&q="+ciudad+"&language=es";
		ClientResource cr = new ClientResource(url);
		SearchLocationKey locationKey = cr.get(SearchLocationKey.class);

		return locationKey;

	}
	
	public SearchWeather getTiempo(String LocationKey) throws UnsupportedEncodingException {
		String url = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/"+LocationKey+"?apikey="+Weather_API_KEY+"&language=es";
						
						ClientResource cr = new ClientResource(url);
						SearchWeather result = cr.get(SearchWeather.class);

		return result;

	}
	
	
	

}
