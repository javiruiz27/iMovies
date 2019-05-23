package aiss.model.resource;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.tmdb.Details;
import aiss.model.tmdb.GuessID;
import aiss.model.tmdb.Rate;
import aiss.model.tmdb.SearchImagen;
import aiss.model.tmdb.SearchMovie;
import aiss.model.tmdb.SearchVideo;

public class TMDBSearchResource {

	private static final String TMDB_API_KEY = "e925e771d23f12d0770dad8d0309141f";
	private static final Logger log = Logger.getLogger(TMDBSearchResource.class.getName());

	public Rate postRate(String idmovie, Double rate) throws UnsupportedEncodingException {
		Rate res = null;
		GuessID guess = TMDBSession.getGuestSession();
		String sessionId = guess.getGuestSessionId();
		log.log(Level.FINE, "El session id es " + sessionId);
		// https://api.themoviedb.org/3/movie/{movie_id}/rating?api_key=<<api_key>>
		String URL = "https://api.themoviedb.org/3/movie/" + idmovie + "/rating?guest_session_id=" + sessionId
				+ "&api_key=" + TMDB_API_KEY;

		ClientResource cr = new ClientResource(URL);
		res = cr.post(rate, Rate.class);
		log.log(Level.FINE, "El comentario ha sido posteado");

		return res;

	}

//	public SearchMovie getMovies(String artist) throws UnsupportedEncodingException {
//
//		String URL = "https://api.themoviedb.org/3/search/movie?api_key=" + TMDB_API_KEY + "&language=ES&query="
//				+ artist + "&page=1";
//
//		ClientResource cr = new ClientResource(URL);
//		SearchMovie ps = cr.get(SearchMovie.class);
//
//		return ps;
//	}

	public SearchMovie getCartelera() throws UnsupportedEncodingException {

		String URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + TMDB_API_KEY + "&language=EN&page=1";

		ClientResource cr = new ClientResource(URL);
		SearchMovie ps = cr.get(SearchMovie.class);

		return ps;
	}

	public SearchMovie getMovieByName(String name) throws UnsupportedEncodingException {

		String URL = "https://api.themoviedb.org/3/search/movie?api_key=" + TMDB_API_KEY + "&language=EN&query=" + name
				+ "&page=1";
		ClientResource cr = new ClientResource(URL);
		SearchMovie ps = cr.get(SearchMovie.class);

		return ps;

	}

	public SearchVideo getVideo(Integer id) throws UnsupportedEncodingException {

		String URL = "https://api.themoviedb.org/3/movie/" + id + "/videos?api_key=" + TMDB_API_KEY + "&language=EN";
		// https://api.themoviedb.org/3/movie/{movie_id}/videos?api_key=<<api_key>>&language=en-US

		ClientResource cr = new ClientResource(URL);
		SearchVideo ps = cr.get(SearchVideo.class);

		return ps;
	}

	public Details getDetalles(Integer id) throws UnsupportedEncodingException {

		String URL = "https://api.themoviedb.org/3/movie/" + id + "?api_key=" + TMDB_API_KEY + "&language=EN";

		ClientResource cr = new ClientResource(URL);
		Details ps = cr.get(Details.class);

		return ps;
	}

	public SearchImagen getImagen(Integer id) throws UnsupportedEncodingException {

		String URL = "https://api.themoviedb.org/3/movie/" + id + "/images?api_key=" + TMDB_API_KEY + "&language=EN";

		ClientResource cr = new ClientResource(URL);
		SearchImagen ps = cr.get(SearchImagen.class);

		return ps;
	}
}
