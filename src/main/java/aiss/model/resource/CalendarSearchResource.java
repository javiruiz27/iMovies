package aiss.model.resource;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;

import org.restlet.resource.ClientResource;

import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;

import aiss.model.calendar.ListCalendar;
import aiss.model.tmdb.SearchMovie;

// ...

// Initialize Calendar service with valid OAuth credentials

public class CalendarSearchResource{

	private final String access_token;
	 private final String uri = "https://www.googleapis.com/calendar/v3/users/me/calendarList";
	 

	    public CalendarSearchResource(String access_token) {
	        this.access_token = access_token;
	    }

//	public List<Calendar> ObtenerCalendarios(httpTransport, jsonFactory, credentials){
//	    // Initialize Calendar service with valid OAuth credentials
//	    Calendar service = new Calendar.Builder(httpTransport, jsonFactory, credentials)
//	        .setApplicationName("iMovies").build();
//
//	    // Iterate through entries in calendar list
//	    String pageToken = null;
//	    do {
//	      CalendarList calendarList = service.calendarList().list().setPageToken(pageToken).execute();
//	      List<CalendarListEntry> items = calendarList.getItems();
//
//	      for (CalendarListEntry calendarListEntry : items) {
//	        System.out.println(calendarListEntry.getSummary());
//	      }
//	      pageToken = calendarList.getNextPageToken();
//	    } while (pageToken != null);
//
//	    return items;
//	}
	    
	    public ListCalendar getCalendarios() throws UnsupportedEncodingException {

			String URL = "uri";

			ClientResource cr = new ClientResource(URL);
			ListCalendar ps = cr.get(ListCalendar.class);

			return ps;
		} 
	
}
