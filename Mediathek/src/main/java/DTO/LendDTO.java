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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LendDTO {
    int lendID;
    Customer customer;
    Double costPerDay;
    LocalDate dateOfAusleihe;

    @PersistenceContext
    EntityManager em;

    public LendDTO() {
    }

    String path = "../resources/Lend.csv";
    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Lend(getbyId(Integer.parseInt(a[3])),Double.parseDouble(a[1]), LocalDate.parse(a[2])))
                .forEach(em::merge);
    }

    public Customer getbyId(int id){
        Customer customer = (Customer)em.createQuery("select c from Customer c where c.getCustomerId = :id").setParameter("id", id).getSingleResult();
        return customer;
    }

    public int getLendID() {
        return lendID;
    }

    public void setLendID(int lendID) {
        this.lendID = lendID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public LocalDate getDateOfAusleihe() {
        return dateOfAusleihe;
    }

    public void setDateOfAusleihe(LocalDate dateOfAusleihe) {
        this.dateOfAusleihe = dateOfAusleihe;
    }
}
