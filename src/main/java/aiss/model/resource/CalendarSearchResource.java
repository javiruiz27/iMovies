package aiss.model.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.restlet.resource.ClientResource;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.calendar.CalendarScopes;

import aiss.CalendarQuickstart;
import aiss.model.calendar.ListCalendar;

// ...

// Initialize Calendar service with valid OAuth credentials

public class CalendarSearchResource{

	
	private final String access_token;
	 private final String uri = "https://www.googleapis.com/calendar/v3/users/me/calendarList";
	 private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_READONLY);
	 private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
	 private final NetHttpTransport HTTP_TRANSPORT;
	 

	    public CalendarSearchResource(String access_token) {
	        this.access_token = access_token;
	    }
 
	
	public List<Calendar> ObtenerCalendarios(HTTP_TRANSPORT, jsonFactory, CREDENTIALS_FILE_PATH){
	    // Initialize Calendar service with valid OAuth credentials
	    Calendar service = new Calendar.Builder(httpTransport, jsonFactory, credentials)
	        .setApplicationName("iMovies").build();

	    // Iterate through entries in calendar list
	    String pageToken = null;
	    do {
	      CalendarList calendarList = service.calendarList().list().setPageToken(pageToken).execute();
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
