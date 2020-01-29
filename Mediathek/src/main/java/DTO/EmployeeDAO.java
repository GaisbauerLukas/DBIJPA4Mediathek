package DTO;

import Entity.Customer;
import Entity.Employee;
import Entity.Store;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

public class EmployeeDAO {


    @PersistenceContext
    EntityManager em;

    public EmployeeDAO() {
    }

    String path = "/csv/Employee.csv";
    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Employee(a[1]))
                .forEach(em::merge);
    }

    public List<Store> getbyId(String[] ids){
        List<Store> stores = null;
        for(int i = 0; i < ids.length; i++){
            stores.add((Store)em.createQuery("select s from Store s where s.storeId = :id").setParameter("id", Integer.parseInt(ids[i])).getSingleResult());
        }

        return stores;
    }


}
