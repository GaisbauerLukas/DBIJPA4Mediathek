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
    public List<Movie> getMovieByGenere(Genre genre){
        return null;
    }

    public List<Movie> getMovieByActor(Actor actor){
        return null;
    }
    public List<Movie> getMovieByStudio(Studio studio){
        return null;
    }
    public List<Movie> getMovieByRecordLocation(RecordLocation recordLocation){
        return null;
    }
    public Boolean isLend(Movie movie){
        return false;
    }
}
