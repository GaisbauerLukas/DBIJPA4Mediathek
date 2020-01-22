package DTO;

import Entity.Employee;
import Entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class LocationDTO {


    @PersistenceContext
    EntityManager em;

    public LocationDTO() {
    }

    String path = "../resources/Location.csv";
    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Location(a[1], a[2]))
                .forEach(em::merge);
    }


}
