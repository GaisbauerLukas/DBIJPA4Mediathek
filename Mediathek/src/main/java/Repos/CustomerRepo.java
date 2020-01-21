package Repos;

import Entity.Customer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class CustomerRepo {
    @Inject
    EntityManager em;

    public void updateCustomer(Customer customer) {
        em.createQuery("update Customer set credit = :credit where customerId = :id")
                .setParameter("credit", customer.getCredit())
                .setParameter("id", customer.getCustomerId());
    }

    public void deleteCustomer(long id) {
        em.createQuery("delete from Customer where customerId = :customerid")
                .setParameter("customerid", id);
    }
    public void createCustomer(Customer customer){
        //implement
    }
}
