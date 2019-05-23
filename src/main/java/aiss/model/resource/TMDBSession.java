package aiss.model.resource;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.tmdb.GuessID;

public class TMDBSession {
	
	private static final String TMDB_API_KEY = "e925e771d23f12d0770dad8d0309141f";
	private static final Logger log = Logger.getLogger(TMDBSession.class.getName());
	
	public static GuessID getGuestSession() throws UnsupportedEncodingException {

		String URL = "https://api.themoviedb.org/3/authentication/guest_session/new?api_key=" + TMDB_API_KEY;

		ClientResource cr = new ClientResource(URL);
		GuessID g = cr.get(GuessID.class);

		return g;

	}
	
	
	

}
