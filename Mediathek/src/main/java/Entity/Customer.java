package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customerId;

    String name;

    @OneToOne(cascade = {CascadeType.ALL})
    CustomerDetail customerDetail;

    @OneToMany
    List<Bill> bills;

    double credit;

    public Customer(){}
    public Customer(String name, double credit, CustomerDetail customerDetail, List<Bill> bills) {
        this.name = name;
        this.credit = credit;
        this.customerDetail = customerDetail;
        this.bills = bills;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        customerId = customerId;
    }

    public CustomerDetail getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
