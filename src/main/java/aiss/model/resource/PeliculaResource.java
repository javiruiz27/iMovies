package aiss.model.resource;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;


import aiss.model.repository.PeliculaRepository;
import aiss.models.Pelicula;
import javassist.NotFoundException;

@Path("/movies")
public class PeliculaResource {
	
	public static PeliculaResource _instance = null;
	PeliculaRepository repository;

	private PeliculaResource() {
		repository = PeliculaRepository.getInstance();
	}

	public static PeliculaResource getInstance() {
		if (_instance == null)
			_instance = new PeliculaResource();
		return _instance;
	}

	@GET
	@Produces("application/json")
	public Collection<Pelicula> getAll() {
		return repository.getAllPeliculas();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Pelicula get(@PathParam("id") Integer movieId) throws NotFoundException {
		Pelicula peli = repository.getPelicula(movieId);

		if (peli == null) {
			throw new NotFoundException("La pelicula con id=" + movieId + " no se encuentra");
		}

		return peli;
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addMovie(@Context UriInfo uriInfo, Pelicula movie) {
		if (movie.getTitle() == null || "".equals(movie.getTitle()))
			throw new BadRequestException("El nombre de la pelicula no puede ser nulo");

		repository.addPelicula(movie);
		Integer id = movie.getId();
		String titulo = movie.getTitle();
		String id2 = String.valueOf(id);
		repository.agregarPelicula(titulo, id2);

		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(movie.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(movie);
		return resp.build();
	}

	@PUT
	@Consumes("application/json")
	public Response updateMovie(Pelicula movie) throws NotFoundException {
		Pelicula oldmovie = repository.getPelicula(movie.getId());
		String titulo = oldmovie.getTitle();
		repository.eliminarPelicula(titulo);
		if (oldmovie == null) {
			throw new NotFoundException("La pelicula con id=" + movie.getId() + " no se ecuentra");
		}

		if (movie.getTitle() != null) {
			oldmovie.setTitle(movie.getTitle());
			repository.actualizarpeli(movie.getTitle(), movie.getId());
		}
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteMovie(@PathParam("id") Integer movieId) throws NotFoundException {
		Pelicula toberemoved = repository.getPelicula(movieId);
		String titulo = repository.getPelicula(movieId).getTitle();

		if (toberemoved == null)
			throw new NotFoundException("La pelicula con id=" + movieId + " no se encuentra");
		else
			repository.deletePelicula(movieId);
		repository.borrarPelicula(titulo);

		return Response.noContent().build();
	}

}
