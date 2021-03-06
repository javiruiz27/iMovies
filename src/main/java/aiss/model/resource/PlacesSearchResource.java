package aiss.model.resource;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.places.Search;

public class PlacesSearchResource {

	private static final String PLACES_API_KEY = "AIzaSyCNEj2orEZ7nDkXBf6rDJCwpBD2dpAJelM";
	private static final Logger log = Logger.getLogger(PlacesSearchResource.class.getName());

	public Search getPlaces(String place) throws UnsupportedEncodingException {
		String url = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=cines+" + place + "&key="
				+ PLACES_API_KEY;
		ClientResource cr = new ClientResource(url);
		Search result = cr.get(Search.class);

		return result;

	}
	
	public Search getFotos(String referencia) throws UnsupportedEncodingException {
		String url = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=" + referencia+ "&key=" + PLACES_API_KEY;
						
						ClientResource cr = new ClientResource(url);
						Search result = cr.get(Search.class);

		return result;

	}
	
	
	

}
