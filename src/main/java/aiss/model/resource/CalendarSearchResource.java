package aiss.model.resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.restlet.resource.ClientResource;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.Calendar.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;

import aiss.model.calendar.ListCalendar;


// ...

// Initialize Calendar service with valid OAuth credentials

public class CalendarSearchResource{

	
	private final String access_token;
	private final String uri = "https://www.googleapis.com/calendar/v3/users/me/calendarList";
	 

	    public CalendarSearchResource(String access_token) {
	        this.access_token = access_token;
	    }
	    
	    

	   
	public List<CalendarListEntry> ObtenerCalendarios(final NetHttpTransport HTTP_TRANSPORT, JsonFactory jsonFactory, Credential credentials){
	    // Initialize Calendar service with valid OAuth credentials
	    Calendar service = new Calendar.Builder(HTTP_TRANSPORT, jsonFactory, credentials)
	        .setApplicationName("iMovies").build();

	    // Iterate through entries in calendar list
	    String pageToken = null;
	    do {
	     com.google.api.services.calendar.model.CalendarList calendarList = service.calendarList().list().setPageToken(pageToken).execute();
	      List<CalendarListEntry> items = calendarList.getItems();

	      for (CalendarListEntry calendarListEntry : items) {
	        System.out.println(calendarListEntry.getSummary());
	      }
	      pageToken = calendarList.getNextPageToken();
	    } while (pageToken != null);

	    return items;
	}
	    
	    public ListCalendar getCalendarios() throws UnsupportedEncodingException {

			String URL = "uri";

			ClientResource cr = new ClientResource(URL);
			ListCalendar ps = cr.get(ListCalendar.class);

			return ps;
		} 
	
}
