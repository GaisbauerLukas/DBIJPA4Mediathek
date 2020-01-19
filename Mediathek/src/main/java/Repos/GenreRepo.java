package Repo;

import Entity.Genre;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class GenreRepo {
    @Inject
    EntityManager em;

    public void updateGenre(Genre genre) {
        em.createQuery("update Genre set genre = :genre, movieGenres = :movieGenres where genre.genreId = :id")
                .setParameter("genre", genre.getGenre())
                .setParameter("movieGenres", genre.getMovieGenres())
                .setParameter("id", genre.getGenreId());
    }

    public void deleteGenre(long id) {
        em.createQuery("delete from Genre where Genre.genreId = :genreid")
                .setParameter("genreid", id);
    }
}

