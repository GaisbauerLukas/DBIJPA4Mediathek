package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

    int costPerDay;
    Date dateOfAusleihe;

    public Lend(){}

    public Lend( Customer customer, int costPerDay, Date dateOfAusleihe) {
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

    public int getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    public Date getDateOfAusleihe() {
        return dateOfAusleihe;
    }

    public void setDateOfAusleihe(Date dateOfAusleihe) {
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
