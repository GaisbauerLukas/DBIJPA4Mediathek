package Entity;

import DTO.CustomerDTO;

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
    public Customer(int customerId, int credit, CustomerDetail customerDetail) {
        CustomerId = customerId;
        this.credit = credit;
        this.customerDetail = customerDetail;
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
