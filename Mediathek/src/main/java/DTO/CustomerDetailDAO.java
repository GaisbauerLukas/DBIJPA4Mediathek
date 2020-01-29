package DTO;

import Entity.Actor;
import Entity.CustomerDetail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerDetailDAO {



    @PersistenceContext
    EntityManager em;

    public CustomerDetailDAO() {
    }

    String path = "/csv/CustomerDetail.csv";

    public void readFromCSV(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                //.map(a -> new CustomerDetail(a[0], a[1], a[2],LocalDate.parse(a[3],dateTimeFormatter), a[4], a[5]))
                .forEach(em::merge);
    }


}
