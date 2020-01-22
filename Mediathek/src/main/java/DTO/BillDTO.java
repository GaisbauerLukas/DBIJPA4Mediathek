package DTO;

import Entity.Bill;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class BillDTO {


    @PersistenceContext
    EntityManager entityManager;

    public BillDTO() {
    }

    String path = "../resources/csv/Bill.csv";
    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Bill( a[1], Integer.parseInt(a[2])))
                .forEach(entityManager::merge);
    }

}
