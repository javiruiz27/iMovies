package aiss;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.calendar.ListCalendar;
import aiss.model.resource.CalendarSearchResource;

/**
 * Servlet implementation class PeliculasActualesSearchController
 */
public class ListCalendarSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ListCalendarSearchController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListCalendarSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		 String accessToken = (String) request.getSession().getAttribute("GoogleCalendar-token");

		CalendarSearchResource calendars = new CalendarSearchResource(accessToken);

		ListCalendar calendarios = calendars.getCalendarios();
		String idCalendario = calendarios.getItems().get(0).getId();


		if (idCalendario !="") {
			rd = request.getRequestDispatcher("/muestraCalendario.jsp");
			request.setAttribute("idCalendario", idCalendario);
		

			log.log(Level.INFO, "Se a conseguido el id del primer calendario:" + idCalendario);

		} else {
			log.log(Level.INFO, "Ha ocurrido un fallo al cargar el id del calendario.");
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
