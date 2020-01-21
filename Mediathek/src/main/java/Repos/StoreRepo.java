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
        //implement
    }
    public List<Lend> getLendsOfStore(Store store){
        //implement
        return null;
    }
    public List<Customer> getCustomersOfStore(Store store){
        return null;
    }
    public List<Movie> getMoviesOfStore(Store store){
        return null;
    }
    public void createLendOfStore(Lend lend, Store store){
        //implement
    }
}
