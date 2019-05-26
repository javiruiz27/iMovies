package iMovies;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.resource.TMDBSearchResource;
import aiss.model.resource.TMDBSession;
import aiss.model.tmdb.GuessID;
import aiss.model.tmdb.Result;
import aiss.model.tmdb.SearchMovie;

public class TMDBTest {
	
	@Test
	public void getPeliculasActuales() throws UnsupportedEncodingException{
		
		TMDBSearchResource tmdb = new TMDBSearchResource();
		SearchMovie result = tmdb.getCartelera();
		
		assertNotNull("Search result is null", result);
		
		System.out.println("El tamaño de la cartelera es: " + result.getTotalResults());
		
	}
	
	@Test 
	public void getPeliculasPorNombre() throws UnsupportedEncodingException{
		String name = "Avengers";
		TMDBSearchResource tmdb = new TMDBSearchResource();
		SearchMovie result = tmdb.getMovieByName(name);
		try {
			Result res = result.getResults().get(0);
			System.out.println(res.getOriginalTitle());
		} catch (Exception e) {
			System.out.println("La película introducida no se encuentra en nuestra base de datos,");
			System.out.println("revise la escritura o el idioma introducido.");
		}
		
		
		
	}
	
	@Test
	public void getSession() throws UnsupportedEncodingException{
		
		TMDBSession tmdb = new TMDBSession();
		GuessID result = tmdb.getGuestSession();
		
		assertNotNull("Search result is null", result);
		
		System.out.println("El id de sesion es: " + result.getGuestSessionId());
		
		
		
	} 
	
	

}
