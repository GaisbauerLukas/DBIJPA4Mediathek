package Repo;

import Entity.Store;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class StoreRepo {
    @Inject
    EntityManager em;

    public void updateStore(Store store) {
        em.createQuery("update Store set street = :street, employees = :employees, bills = :bills, location = :location " +
                "where store.storeId = :id")
                .setParameter("street", store.getStreet())
                .setParameter("employees", store.getEmployees())
                .setParameter("bills", store.getBills())
                .setParameter("location", store.getLocation())
                .setParameter("id", store.getStoreId());
    }

    public void deleteStore(long id) {
        em.createQuery("delete from Store where Store.storeId = :storeid")
                .setParameter("storeid", id);
    }
}
