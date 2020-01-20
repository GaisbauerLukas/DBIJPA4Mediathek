package DTO;

import Entity.Customer;
import Entity.Genre;
import Entity.Lend;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LendDTO {
    @PersistenceContext
    EntityManager em;



    String path = "../resources/Lend.csv";
    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Lend(Integer.parseInt(a[0]),getbyId(Integer.parseInt(a[0])) ,Integer.parseInt(a[2]), Date.valueOf(a[3])))
                .forEach(em::merge);
    }

    public Customer getbyId(int id){
        Customer customer = (Customer)em.createQuery("select c from Customer c where c.getCustomerId() = :id").setParameter("id", id).getSingleResult();
        return customer;
    }
}
