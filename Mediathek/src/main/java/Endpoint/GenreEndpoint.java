package Endpoint;

import Entity.Actor;
import Entity.Genre;
import Repos.GenreRepo;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("api/Genre")
public class GenreEndpoint {

    @Inject
    GenreRepo genreRepo;

    @Path("create")
    @POST
    public void create(Genre genre) {
        genreRepo.createGenre(genre);
    }

    @Path("update")
    @PUT
    public void update(Genre genre){
        genreRepo.updateGenre(genre);
    }

    @Path("delete-{id}")
    @DELETE
    public void delete(@PathParam("id") int id){
        genreRepo.deleteGenre(id);
    }
}
