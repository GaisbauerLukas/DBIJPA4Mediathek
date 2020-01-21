package Repos;

import Entity.Movie;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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
        em.createQuery("delete from Movie where Movie.movieId = :movieid")
                .setParameter("movieid", id);
    }
}
