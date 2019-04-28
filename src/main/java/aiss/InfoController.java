package aiss;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.TMDBSearchResource;
import aiss.model.tmdb.Details;
import aiss.model.tmdb.Poster;
import aiss.model.tmdb.Result2;
import aiss.model.tmdb.SearchImagen;
import aiss.model.tmdb.SearchVideo;

/**
 * Servlet implementation class InfoController
 */
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(InfoController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;

		TMDBSearchResource tmdb = new TMDBSearchResource();
		//String url2 = "https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg";
		String titulo = request.getParameter("titulo");
		String id = request.getParameter("id");
		String actuales = request.getParameter("actuales");


		//String url3= "https://www.themoviedb.org/movie/299537-captain-marvel#play=Z1BCujX3pw8";
		Integer id2 = Integer.parseInt(id);
		
		SearchImagen imagen = tmdb.getImagen(id2);
		List<Poster> imagenes = imagen.getPosters();
		Poster poster = imagenes.get(0);
		String url2 ="https://image.tmdb.org/t/p/w300/" + poster.getFilePath();
		
		SearchVideo video= tmdb.getVideo(id2);
		List<Result2> videos= video.getResults();
		Result2 r2= videos.get(0);
		String url3= "https://www.youtube.com/v/" + r2.getKey();
		
		Details detalles = tmdb.getDetalles(id2);
		String overview = detalles.getOverview();
		String imdbID = detalles.getImdbId();
		String fechaEstreno = detalles.getReleaseDate();
		Double puntuacion = detalles.getVoteAverage();

		if(poster.getFilePath()!=null || imagenes.size()!=0) {
			rd = request.getRequestDispatcher("/infoPeliculas.jsp");
			request.setAttribute("overview", overview);
			request.setAttribute("imdbID", imdbID);
			request.setAttribute("titulo", titulo);
			request.setAttribute("fechaEstreno", fechaEstreno);
			request.setAttribute("puntuacion", puntuacion);
			request.setAttribute("url2", url2);
			request.setAttribute("url3", url3);
			request.setAttribute("actuales", actuales);
			
			log.log(Level.INFO, "No hay problemas");
			log.log(Level.INFO, "Valor de actuales:" + actuales);
			
			
		}else {
			rd=request.getRequestDispatcher("/infoPeliculasError.jsp");
			request.setAttribute("overview", overview);
			request.setAttribute("imdbID", imdbID);
			request.setAttribute("titulo", titulo);
			request.setAttribute("fechaEstreno", fechaEstreno);
			request.setAttribute("puntuacion", puntuacion);
			request.setAttribute("url3", url3);
			request.setAttribute("actuales", actuales);
			
			log.log(Level.INFO, "No existen imagenes");
		}

		log.log(Level.INFO, "Mostrando información detallada de: " + titulo + " con id: " + id);
		rd.forward(request, response);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
