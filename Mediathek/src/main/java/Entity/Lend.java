package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Lend {
    @Id
    int lendID;

    @ManyToOne
    Customer customer;

    @ManyToOne
    Store store;

    @OneToOne
    Movie movie;

    Double costPerDay;
    LocalDate dateOfAusleihe;

    public Lend(){}

    public Lend( Customer customer, Double costPerDay, LocalDate dateOfAusleihe) {
        this.costPerDay = costPerDay;
        this.dateOfAusleihe = dateOfAusleihe;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
