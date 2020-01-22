package DTO;

import Entity.Actor;
import Entity.CustomerDetail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Date;
import java.time.LocalDate;

public class CustomerDetailDTO {



    @PersistenceContext
    EntityManager em;

    public CustomerDetailDTO() {
    }

    String path = "../resources/csv/Actor.csv";

    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new CustomerDetail(Integer.parseInt(a[0]), a[1], a[2], LocalDate.parse(a[3]), a[4], a[5]))
                .forEach(em::merge);
    }


}
