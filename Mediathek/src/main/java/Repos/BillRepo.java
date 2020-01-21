package Repos;

import Entity.Bill;
import Entity.Customer;
import Entity.Lend;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BillRepo {
    @Inject
    EntityManager em;

    public void updateBill(Bill bill) {
        em.createQuery("update Bill set movie = :movie, cost = :cost where billId = :id")
                .setParameter("movie", bill.getMovie())
                .setParameter("cost", bill.getCost())
                .setParameter("id", bill.getBillId());
    }

    public void deleteBill(long id) {
        em.createQuery("delete from Bill where billId = :billid")
                .setParameter("billid", id);
    }
    public void createBill(Bill bill){
        em.persist(bill);
    }
    public void createBillOfLend(Lend lend){
        //implement delete rend get cost out of rend(via Rend Repo and create new bill
    }
    public List<Bill> getBillByCustomer(Customer customer){
        return null;
    }
}
