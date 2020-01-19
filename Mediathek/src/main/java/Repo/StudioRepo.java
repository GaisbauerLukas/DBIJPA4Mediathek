package Repo;

import Entity.Studio;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class StudioRepo {
    @Inject
    EntityManager em;

    public void updateStudio(Studio studio) {
        em.createQuery("update Studio set studioName = :studioName, movies = :movies where movies.movieId = :id")
                .setParameter("studioName", studio.getStudioName())
                .setParameter("movies", studio.getMovies())
                .setParameter("id", studio.getStudioId());
    }

    public void deleteStudio(long id) {
        em.createQuery("delete from Studio where Studio.studioId = :studioid")
                .setParameter("studioid", id);
    }
}
