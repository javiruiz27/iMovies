package iMovies;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import aiss.model.resource.WeatherSearchResource;
import aiss.model.weather.SearchWeather;
import aiss.model.weather.Weather;

public class WeatherTest{
	
	@Test
	public void getTiempo() throws UnsupportedEncodingException {

		String lugar = "oslo";
		
		SearchWeather weather = null;

		WeatherSearchResource items = new WeatherSearchResource();
		try {
			weather = items.getWeather(lugar);
		} catch (Exception e) {
			System.out.println("La ciudad introducida no se encuentra en nuestra base de datos,");
			System.out.println("revise la escritura o el idioma introducido.");
		}	
		List<aiss.model.weather.List> tiempo = weather.getList();
		System.out.println("El tiempo en "+lugar+" es "+ tiempo.get(0).getMain().getTemp()+"°C");
		

	}
	
}