package iMovies;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import aiss.model.places.Result;
import aiss.model.places.Search;
import aiss.model.resource.PlacesSearchResource;

public class PlacesTest {
	
	@Test
	public void getCines() throws UnsupportedEncodingException{
		
		String lugar = "sevilla";
		
		PlacesSearchResource places = new PlacesSearchResource();
		
		Search search = places.getPlaces(lugar);
		
		List<Result> result = search.getResults();
		
		assertNotNull("Search result is null", result);
		
		System.out.println("Los cines en sevilla son: " + result.size());
	
				
	}

}
