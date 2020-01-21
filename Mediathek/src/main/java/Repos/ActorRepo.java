package Repos;

import Entity.Actor;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class ActorRepo {
    @Inject
    EntityManager em;

    public void updateActor(Actor actor) {
        em.createQuery("update Actor set name = :name, actorMovies = :actorMovies where actor.actorId = :id")
                .setParameter("name", actor.getName())
                .setParameter("actorMovies", actor.getActorMovies())
                .setParameter("id", actor.getActorId());
    }

    public void deleteActor(long id) {
        em.createQuery("delete from Actor where Actor.actorId = :actorid")
                .setParameter("actorid", id);
    }
    public void createActor(Actor actor){
        //implement
    }
}
