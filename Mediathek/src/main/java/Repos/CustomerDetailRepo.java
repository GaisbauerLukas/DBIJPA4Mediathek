package Repo;

import Entity.CustomerDetail;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class CustomerDetailRepo {
    @Inject
    EntityManager em;

    public void updateCustomerDetail(CustomerDetail cd) {
        em.createQuery("update CustomerDetail set phoneNumber = :phoneNumber, email = :email, birthday = :birthday, " +
                "favoriteMovie = :favoriteMovie, religion = :religion" +
                " where customerDetail.customerId = :id")
                .setParameter("phoneNumber", cd.getPhoneNumber())
                .setParameter("email", cd.getEmail())
                .setParameter("birthday", cd.getBirthday())
                .setParameter("favoriteMovie", cd.getFavouriteMovie())
                .setParameter("religion", cd.getReligion())
                .setParameter("id", cd.getCustomerId());
    }

    public void deleteCustomerDetail(long id) {
        em.createQuery("delete from CustomerDetail where CustomerDetail.customerId = :cdid")
                .setParameter("cdid", id);
    }
}
