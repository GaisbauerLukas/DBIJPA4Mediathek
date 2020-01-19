package Repo;

import Entity.Lend;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class LendRepo {
    @Inject
    EntityManager em;

    public void updateLend(Lend lend) {
        em.createQuery("update Lend set customer = :customer, costPerDay = :costPerDay, " +
                "dateOfAusleihe = :dateOfAusleihe " +
                "where lend.lendID = :id")
                .setParameter("customer", lend.getCustomer())
                .setParameter("costPerDay", lend.getCostPerDay())
                .setParameter("dateOfAusleihe", lend.getDateOfAusleihe())
                .setParameter("id", lend.getLendID());
    }

    public void deleteLend(long id) {
        em.createQuery("delete from Lend where Lend.lendID = :lendid")
                .setParameter("lendid", id);
    }
}
