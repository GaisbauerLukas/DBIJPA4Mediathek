package Repo;

import Entity.Location;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class LocationRepo {
    @Inject
    EntityManager em;

    public void updateLocation(Location location) {
        em.createQuery("update Location set country = :country, city = :city, stores = :stores " +
                "where location.locationId = :id")
                .setParameter("country", location.getCountry())
                .setParameter("city", location.getCity())
                .setParameter("stores", location.getStores())
                .setParameter("id", location.getLocationId());
    }

    public void deleteLocation(long id) {
        em.createQuery("delete from Location where Location.locationId = :locationId")
                .setParameter("locationId", id);
    }
}
