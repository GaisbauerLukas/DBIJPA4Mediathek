package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int storeId;
    String street;
    @OneToMany
    List<Employee> employees;
    @OneToMany
    List<Bill> bills;
    @ManyToOne
    Location location;
    @OneToMany
    List<Lend> lends;
    @OneToMany
    List<Movie> movies;

    public Store(){}

    public Store(String street, List<Employee> employees, List<Bill> bills, Location location, List<Lend> lends, List<Movie> movies) {
        this.street = street;
        this.employees = employees;
        this.bills = bills;
        this.location = location;
        this.lends = lends;
        this.movies = movies;
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

    public List<Lend> getLends() {
        return lends;
    }

    public void setLends(List<Lend> lends) {
        this.lends = lends;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
