package Endpoint;

import Entity.*;
import Repos.MovieRepo;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("Movie")
public class MovieEndpoint {
    @Inject
    MovieRepo movieRepo;

    @Path("create")
    @POST
    public void create(Movie movie) {
        movieRepo.createMovie(movie);
    }

    @Path("update")
    @PUT
    public void update(Movie movie){
        movieRepo.updateMovie(movie);
    }

    @Path("delete-{id}")
    @DELETE
    public void delete(@PathParam("id") int id){
        movieRepo.deleteMovie(id);
    }

    @Path("GetMovieByActor")
    @GET
    public void getByActor(Actor actor){
        movieRepo.getMovieByActor(actor);
    }

    @Path("GetMovieByGenre")
    @GET
    public void getByGenre(Genre genre){
        movieRepo.getMovieByGenre(genre);
    }
    @Path("GetMovieByStudio")
    @GET
    public void getByStudio(Studio studio){
        movieRepo.getMovieByStudio(studio);
    }
    @Path("GetMovieByRecordLocation")
    @GET
    public void getByRecordLocation(RecordLocation recordLocation){
        movieRepo.getMovieByRecordLocation(recordLocation);
    }
    @Path("GetLendInfo")
    @GET
    public void getLendInfo(Movie movie){
        movieRepo.isLend(movie);
    }
}
