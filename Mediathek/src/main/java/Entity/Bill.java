package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int billId;
    String movie;
    int cost;
    @OneToMany
    List<Store> stores;

    public Bill(){
    }

    public Bill(String movie, int cost, List<Store> store) {
        this.movie = movie;
        this.cost = cost;
        this.stores = store;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Store> getStore() {
        return stores;
    }

    public void setStore(List<Store> store) {
        this.stores = store;
    }
}
