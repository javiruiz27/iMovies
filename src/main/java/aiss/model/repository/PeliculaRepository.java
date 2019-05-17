package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;


import aiss.models.Pelicula;

public class PeliculaRepository {
	
	private static final Logger log = Logger.getLogger(PeliculaRepository.class.getName());

	private Map<String, Integer> favoritas;
	private static PeliculaRepository instance = null;

	Map<Integer, Pelicula> peliculas;

	public static PeliculaRepository getInstance() {

		if (instance == null) {
			instance = new PeliculaRepository();
			instance.init();
		}

		return instance;
	}

	public void init() {
		favoritas = new HashMap<String, Integer>();
		agregarPelicula("EndGame", "01");
		agregarPelicula("Shazam", "02");

		peliculas = new HashMap<Integer, Pelicula>();

		// Create Pelicula
		Pelicula p = new Pelicula();
		p.setId(001);
		p.setTitle("Infinity War");
		addPelicula(p);

		Pelicula m = new Pelicula();
		m.setId(002);
		m.setTitle("Deadpool 2");
		addPelicula(m);

	}

	public Map<String, Integer> getListaFavoritas() {
		log.log(Level.INFO, "Mostrando lista de películas favoritas");
		return favoritas;
	}

	public Boolean agregarPelicula(String titulo, String id) {
		Boolean realizado = false;

		Integer añadir = Integer.parseInt(id);

		if (buscarPelicula(titulo)) {

			log.log(Level.INFO, "La película cuyo título: " + titulo + " ya está en la lista.");
		} else {
			favoritas.put(titulo, añadir);

			realizado = true;
			log.log(Level.INFO, "La película cuyo título: " + titulo + " ha sido añadida a la lista de favoritos");
		}

		return realizado;
	}

	public void borrarPelicula(String titulo) {

		Integer id = favoritas.get(titulo);

		deletePelicula(id);
		favoritas.remove(titulo);

		log.log(Level.INFO, "La película con id " + titulo + " fué eliminada");
	}

	public Boolean buscarPelicula(String titulo) {
		Boolean existe = false;
		for (String s : favoritas.keySet()) {
			if (s.equals(titulo)) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	public void eliminarPelicula(String titulo) {

		favoritas.remove(titulo);
	}

	public void actualizarpeli(String titulo, Integer id) {
		favoritas.put(titulo, id);
	}

	public void addPelicula(Pelicula p) {
		Integer id = p.getId();

		p.setId(id);
		peliculas.put(id, p);
	}

	public Collection<Pelicula> getAllPeliculas() {
		return peliculas.values();
	}

	public Pelicula getPelicula(Integer movieId) {
		return peliculas.get(movieId);
	}

	public void updatePelicula(Pelicula p) {
		Pelicula peli = peliculas.get(p.getId());
		peli.setId(p.getId());
		peli.setTitle(p.getTitle());
	}

	public void deletePelicula(Integer movieId) {
		peliculas.remove(movieId);
	}

}
