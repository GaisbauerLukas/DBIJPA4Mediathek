package Repos;

import Entity.Lend;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.GregorianCalendar;
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
        GregorianCalendar date = (GregorianCalendar)em.createQuery("select dateOfAusleihe from Lend  where  lendID = :Id").setParameter("Id",id).getSingleResult();
        GregorianCalendar today = new GregorianCalendar();
        int cost=(int)em.createQuery("select costPerDay from Lend where lendID = :Id").setParameter("Id",id).getSingleResult();
        int daysoff=(int)(today.getTimeInMillis()-date.getTimeInMillis()) / (1000*60*60*24);
        return cost*daysoff;
    }
    public int getCostOfLend(Lend lend){
        GregorianCalendar date = (GregorianCalendar)em.createQuery("select dateOfAusleihe from Lend  where  lendID = :Id").setParameter("Id",lend.getLendID()).getSingleResult();
        GregorianCalendar today = new GregorianCalendar();
        int cost=(int)em.createQuery("select costPerDay from Lend where lendID = :Id").setParameter("Id",lend.getLendID()).getSingleResult();
        int daysoff=(int)(today.getTimeInMillis()-date.getTimeInMillis()) / (1000*60*60*24);
        return cost*daysoff;
    }
    public void createLendsByList(List<Lend> lends){
        for (Lend lend: lends) {
            em.persist(lend);
        }
    }
}
