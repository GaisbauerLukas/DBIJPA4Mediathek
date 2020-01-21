package Repos;

import Entity.Lend;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class LendRepo {
    @Inject
    EntityManager em;

    public void updateLend(Lend lend) {
        em.createQuery("update Lend set customer = :customer, costPerDay = :costPerDay, " +
                "dateOfAusleihe = :dateOfAusleihe where lendID = :id")
                .setParameter("customer", lend.getCustomer())
                .setParameter("costPerDay", lend.getCostPerDay())
                .setParameter("dateOfAusleihe", lend.getDateOfAusleihe())
                .setParameter("id", lend.getLendID());
    }

    public void deleteLend(long id) {
        em.createQuery("delete from Lend where Lend.lendID = :lendid")
                .setParameter("lendid", id);
    }
    public void createLend(Lend lend){
        //implement
    }
    public void getCostOfLend(int id){
        //implement
    }
    public void getCostOfLend(Lend lend){
        //implement
    }
    public void createLendsByList(List<Lend> lends){
        //implement
    }
}
