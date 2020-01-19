package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
    @Id
    int CustomerId;

    @OneToOne
    CustomerDetail customerDetail;

    int credit;
}
