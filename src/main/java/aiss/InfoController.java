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

		log.log(Level.FINE, "Aquí estamos 1 -------------------------------------------------");

		TMDBSearchResource tmdb = new TMDBSearchResource();

		// String url2 =
		// "https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg";

		// String url2 =
		// "https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg";

		String titulo = request.getParameter("titulo");
		log.log(Level.FINE, "Aquí estamos:" + titulo);
		String id = request.getParameter("id");
		log.log(Level.FINE, "Aquí estamos:" + id);
		String actuales = request.getParameter("actuales");
		log.log(Level.FINE, "Aquí estamos:" + actuales);
		log.log(Level.FINE, "Aquí estamos 2 -------------------------------------------------");
		// String url3=
		// "https://www.themoviedb.org/movie/299537-captain-marvel#play=Z1BCujX3pw8";
		Integer id2 = Integer.parseInt(id);
		log.log(Level.FINE, "Aquí estamos 3:" + id2);
		SearchImagen imagen = tmdb.getImagen(id2);
		log.log(Level.FINE, "Aquí estamos 4:" + imagen);

		List<Poster> imagenes = imagen.getPosters();
		if (imagenes.isEmpty()) {
			rd = request.getRequestDispatcher("/infoPeliculasError.jsp");
			log.log(Level.FINE, "Lo mandamos");
			rd.forward(request, response);
		} else {
			log.log(Level.FINE, "Aquí estamos 5:" + imagenes);
			Poster poster = imagenes.get(0);
			log.log(Level.FINE, "Aquí estamos 6:" + poster);
			String url2 = "https://image.tmdb.org/t/p/w300/" + poster.getFilePath();
			log.log(Level.FINE, "Aquí estamos 7:" + url2);
			SearchVideo video = tmdb.getVideo(id2);
			log.log(Level.FINE, "Aquí estamos .-----:" + video);
			List<Result2> videos = video.getResults();
			log.log(Level.FINE, "Aquí estamos:" + videos);
			Result2 r2 = videos.get(0);
			log.log(Level.FINE, "Aquí estamos:" + r2);
			String url3 = "https://www.youtube.com/v/" + r2.getKey();
			log.log(Level.FINE, "Aquí estamos:" + url3);
			Details detalles = tmdb.getDetalles(id2);
			log.log(Level.FINE, "Aquí estamos:" + detalles);
			String overview = detalles.getOverview();
			log.log(Level.FINE, "Aquí estamos:" + overview);
			String imdbID = detalles.getImdbId();
			log.log(Level.FINE, "Aquí estamos:" + imdbID);
			String fechaEstreno = detalles.getReleaseDate();
			log.log(Level.FINE, "Aquí estamos:" + fechaEstreno);
			Double puntuacion = detalles.getVoteAverage();
			log.log(Level.FINE, "Aquí estamos:" + puntuacion);

			log.log(Level.FINE, "Aquí estamos 2");

			if (poster.getFilePath() != null && imagenes.size() != 0 && overview != null && puntuacion > 3
					&& !url2.isEmpty()) {
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

			} else {
				rd = request.getRequestDispatcher("/infoPeliculasError.jsp");
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
