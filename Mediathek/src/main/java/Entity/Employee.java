package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int empId;
    String name;
    @OneToMany
    List<Store> stores;

    public Employee(){}
    public Employee(String name, List<Store> store) {
        this.name = name;
        this.stores = store;
    }

    public Employee(int empId, String name, List<Store> stores) {
        this.empId = empId;
        this.name = name;
        this.stores = stores;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> store) {
        this.stores = store;
    }
}
