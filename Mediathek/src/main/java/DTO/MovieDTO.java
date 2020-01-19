package DTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MovieDTO {
    @PersistenceContext
    EntityManager entityManager;

    String path = "../resources/Bill.csv";
    public void readFromCSV(){

    }
}
