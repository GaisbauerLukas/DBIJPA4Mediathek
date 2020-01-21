package DTO;

import Entity.Actor;
import Entity.Customer;
import Entity.CustomerDetail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class CustomerDTO {
    int CustomerId;
    CustomerDetail customerDetail;
    int credit;

    @PersistenceContext
    EntityManager em;

    public CustomerDTO() {
    }

    String path = "../resources/Customer.csv";
    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Customer(Integer.parseInt(a[1]),Integer.parseInt(a[1]), getbyId(Integer.parseInt(a[0]))))
                .forEach(em::merge);
    }

    public CustomerDetail getbyId(int id){
        CustomerDetail cd = (CustomerDetail)em.createQuery("select cd from CustomerDetail cd where cd.CustomerId = :id").setParameter("id", id).getSingleResult();
        return cd;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public CustomerDetail getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
