package Repos;

import Entity.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class MovieRepo {
    @Inject
    EntityManager em;

    public void updateMovie(Movie movie) {
        em.createQuery("update Movie set name = :name, actorMovies = :actorMovies, movieLocations = :movieLocations, " +
                "movieGenres = :movieGenres, studio = :studio " +
                "where movieId = :id")
                .setParameter("name", movie.getName())
                .setParameter("actorMovies", movie.getActorMovies())
                .setParameter("movieLocations", movie.getMovieLocations())
                .setParameter("movieGenres", movie.getMovieGenres())
                .setParameter("studio", movie.getStudio())
                .setParameter("id", movie.getStudio());
    }

    public void deleteMovie(long id) {
        em.createQuery("delete from Movie where movieId = :movieid")
                .setParameter("movieid", id);
    }
    public void createMovie(Movie movie){
        em.persist(movie);
    }
    public List<Movie> getMovieByGenre(Genre genre){
        return em.createQuery("select name from Movie where movieId = (select movieId from MovieGenre where movieGenreID.genreId = (select movieGenreID.genreId from Genre where genre = :Genre )) ").setParameter("Genre",genre.getGenre()).getResultList();
    }

    public List<Movie> getMovieByActor(Actor actor){

        return em.createQuery("select name from Movie where movieId = (select movieId from ActorMovie where actorMovieID.actorId = (select actorMovieID.actorId from ActorMovie where actorMovieID.actorId = :Actor )) ").setParameter("Actor",actor.getActorId()).getResultList();

    }
    public List<Movie> getMovieByStudio(Studio studio){

        return em.createQuery("select name from Movie where Studio.studioId= :Studio ").setParameter("Studio",studio.getStudioId()).getResultList();

    }
    public List<Movie> getMovieByRecordLocation(RecordLocation recordLocation){

        return em.createQuery("select name from Movie where movieId = (select movieId from MovieLocation where movieLocationID.locationID = (select recLocId from RecordLocation where city = :Location )) ").setParameter("Location",recordLocation).getResultList();

    }
    public Boolean isLend(Movie movie){

        int cnt = (int)em.createQuery("select count(lendID) from Lend where Movie.name = :Movie").setParameter("Movie",movie).getSingleResult();
        if(cnt ==1)return true;
        return false;

    }
}
