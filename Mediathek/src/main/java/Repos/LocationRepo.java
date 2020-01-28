package Repos;

import Entity.Location;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class LocationRepo {
    @PersistenceContext
    EntityManager em;

    public void updateLocation(Location location) {
        em.createQuery("update Location set country = :country, city = :city where locationId = :id")
                .setParameter("country", location.getCountry())
                .setParameter("city", location.getCity())
                .setParameter("id", location.getLocationId());
    }

    public void deleteLocation(long id) {
        em.createQuery("delete from Location where locationId = :locationId")
                .setParameter("locationId", id);

    }
    public void createLocation(Location location){
        em.persist(location);
    }
}
