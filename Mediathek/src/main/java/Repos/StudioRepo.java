package Repos;

import Entity.Studio;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class StudioRepo {
    @PersistenceContext
    EntityManager em;

    public void updateStudio(Studio studio) {
        em.createQuery("update Studio set studioName = :studioName where studioId = :id")
                .setParameter("studioName", studio.getStudioName())
                .setParameter("id", studio.getStudioId());
    }

    public void deleteStudio(long id) {
        em.createQuery("delete from Studio where studioId = :studioid")
                .setParameter("studioid", id);
    }

    public void createStudio(Studio studio){
        em.persist(studio);
    }
}
