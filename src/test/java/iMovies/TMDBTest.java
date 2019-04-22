package iMovies;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.resource.TMDBSearchResource;
import aiss.model.tmdb.SearchMovie;

public class TMDBTest {
	
	@Test
	public void getPeliculasActuales() throws UnsupportedEncodingException{
		
		TMDBSearchResource tmdb = new TMDBSearchResource();
		SearchMovie result = tmdb.getCartelera();
		
		assertNotNull("Search result is null", result);
		
		System.out.println("El tamaño de la cartelera es: " + result.getTotalResults());
		
	}

}
