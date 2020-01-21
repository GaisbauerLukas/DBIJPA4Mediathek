package Repos;

import Entity.Customer;
import Entity.Lend;
import Entity.Movie;
import Entity.Store;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StoreRepo {
    @Inject
    EntityManager em;

    public void updateStore(Store store) {
        em.createQuery("update Store set street = :street, employees = :employees, bills = :bills, location = :location " +
                "where storeId = :id")
                .setParameter("street", store.getStreet())
                .setParameter("employees", store.getEmployees())
                .setParameter("bills", store.getBills())
                .setParameter("location", store.getLocation())
                .setParameter("id", store.getStoreId());
    }

    public void deleteStore(long id) {
        em.createQuery("delete from Store where storeId = :storeid")
                .setParameter("storeid", id);
    }
    public void createStore(Store store){
        em.persist(store);
    }
    public List<Lend> getLendsOfStore(Store store){
        return em.createQuery("select lendID from Lend where store.storeId = :Store").setParameter("Store",store).getResultList();
    }
    public List<Customer> getCustomersOfStore(Store store){

        return  em.createQuery("select customerId from Customer where customerId in (select customerId from Lend where store.storeId = :Store)").setParameter("Store",store.getStoreId()).getResultList();
    }
    public List<Movie> getMoviesOfStore(Store store){

        return em.createQuery("select movieId from Movie where movieId in (select movieId from Store where storeId = :Store)").setParameter("Store",store.getStoreId()).getResultList();
    }
    public void createLendOfStore(Lend lend, Store store){
        //implement
    }
}
