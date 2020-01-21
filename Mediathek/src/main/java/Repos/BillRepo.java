package Repos;

import Entity.Bill;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
        em.createQuery("delete from Bill where Bill.billId = :billid")
                .setParameter("billid", id);
    }
}
