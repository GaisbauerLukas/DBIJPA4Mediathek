package DTO;

import Entity.*;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

public class StoreDTO {
    int storeId;
    String street;
    List<Employee> employees;
    List<Bill> bills;
    Location location;

    @PersistenceContext
    EntityManager em;

    public StoreDTO() {
    }

    String path = "../resources/Store.csv";
    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Store(a[1], getEmployeesbyId(a[2].split(",")),getBillsbyId(a[3].split(",")), getLocationbyId(Integer.parseInt(a[4])), getLendsbyId(a[5].split(",")), getMoviesbyId(a[6].split(","))))
                .forEach(em::merge);
    }

    public List<Employee> getEmployeesbyId(String[] ids){
        List<Employee> employees = null;
        for(int i = 0; i < ids.length; i++){
            employees.add((Employee)em.createQuery("select e from Employee e where e.empId = :id").setParameter("id", Integer.parseInt(ids[i])).getSingleResult());
        }
        return employees;
    }

    public List<Bill> getBillsbyId(String[] ids){
        List<Bill> bills = null;
        for(int i = 0; i < ids.length; i++){
            bills.add((Bill)em.createQuery("select b from Bill b where b.billId = :id").setParameter("id", Integer.parseInt(ids[i])).getSingleResult());
        }

        return bills;
    }

    public Location getLocationbyId(int id){
        Location location = (Location)em.createQuery("select l from Location l where l.locationId = :id").setParameter("id", id).getSingleResult();
        return location;
    }

    public List<Lend> getLendsbyId(String[] ids){
        List<Lend> lends = null;
        for(int i = 0; i < ids.length; i++){
            lends.add((Lend)em.createQuery("select l from Lend l where l.lendID = :id").setParameter("id", Integer.parseInt(ids[i])).getSingleResult());
        }

        return lends;
    }

    public List<Movie> getMoviesbyId(String[] ids){
        List<Movie> movies = null;
        for(int i = 0; i < ids.length; i++){
            movies.add((Movie)em.createQuery("select m from Movie m where m.movieId = :id").setParameter("id", Integer.parseInt(ids[i])));
        }

        return movies;
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
