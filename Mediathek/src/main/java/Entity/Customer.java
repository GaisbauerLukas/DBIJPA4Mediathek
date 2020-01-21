package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
    @Id
    int customerId;

    @OneToOne
    CustomerDetail customerDetail;

    int credit;

    public Customer(){}
    public Customer(int customerId, CustomerDetail customerDetail, int credit) {
        customerId = customerId;
        this.customerDetail = customerDetail;
        this.credit = credit;
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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
