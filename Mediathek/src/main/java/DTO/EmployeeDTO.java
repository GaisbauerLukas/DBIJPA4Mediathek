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

public class EmployeeDTO {
    @PersistenceContext
    EntityManager em;

    String path = "../resources/Employee.csv";
    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Employee(Integer.parseInt(a[0]), a[1], getbyId(Integer.parseInt(a[0]))))
                .forEach(em::merge);
    }

    public List<Store> getbyId(int id){
        List<Store> stores = em.createQuery("select s from Store s where s.getEmployees().get(:id) = :id").setParameter("id", id).getResultList();
        return stores;
    }
}
