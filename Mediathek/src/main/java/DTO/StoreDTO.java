package DTO;

import Entity.Bill;
import Entity.Employee;
import Entity.Location;
import Entity.Store;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import java.util.List;

public class StoreDTO {
    int storeId;
    String street;
    List<Employee> employees;
    List<Bill> bills;
    Location location;

    @PersistenceContext
    EntityManager entityManager;

    public StoreDTO() {
    }

    String path = "../resources/Bill.csv";
    public void readFromCSV(){

    }

    public Store getById(int id){
        //return (Store)entityManager.createQuery("SELECT store from Store store where storeId = :Id").setParameter("Id", id).getSingleResult();
        return null;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
