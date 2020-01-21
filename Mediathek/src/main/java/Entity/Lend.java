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

    public Lend(int lendID, Customer customer, int costPerDay, Date dateOfAusleihe) {
        this.lendID = lendID;
        this.customer = customer;
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
}
