package Repos;

import Entity.Lend;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
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
        em.createQuery("delete from Lend where lendID = :lendid")
                .setParameter("lendid", id);
    }
    public void createLend(Lend lend){
        em.persist(lend);
    }
    public int getCostOfLend(int id){
        Date date = (Date)em.createQuery("select dateOfAusleihe from Lend  where  lendID = :Id").setParameter("Id",id).getSingleResult();
        int daysoff=0;
        int cost=(int)em.createQuery("select costPerDay from Lend where lendID = :Id").setParameter("Id",id).getSingleResult();
        return cost*daysoff;
    }
    public int getCostOfLend(Lend lend){
        Date date = (Date)em.createQuery("select dateOfAusleihe from Lend  where  lendID = :Id").setParameter("Id",lend.getLendID()).getSingleResult();
        int daysoff=0;
        int cost=(int)em.createQuery("select costPerDay from Lend where lendID = :Id").setParameter("Id",lend.getLendID()).getSingleResult();
        return cost*daysoff;
    }
    public void createLendsByList(List<Lend> lends){
        for (Lend lend: lends) {
            em.persist(lend);
        }
    }
}
