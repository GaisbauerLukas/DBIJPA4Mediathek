package Repos;

import Entity.Genre;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class GenreRepo {
    @PersistenceContext
    EntityManager em;

    public void updateGenre(Genre genre) {
        em.createQuery("update Genre set genre = :genre, movieGenres = :movieGenres where genreId = :id")
                .setParameter("genre", genre.getGenre())
                .setParameter("movieGenres", genre.getMovieGenres())
                .setParameter("id", genre.getGenreId());
    }

    public void deleteGenre(long id) {
        em.createQuery("delete from Genre where genreId = :genreid")
                .setParameter("genreid", id);
    }

    public void createGenre(Genre genre){
        em.persist(genre);
    }
}

