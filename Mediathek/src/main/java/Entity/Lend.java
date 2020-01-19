package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Lend {
    @Id
    int lendID;

    @ManyToOne
    Customer customer;

    int costPerDay;
    Date dateOfAusleihe;
}
