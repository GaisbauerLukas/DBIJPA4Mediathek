package Repos;

import Entity.Employee;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class EmplyoeeRepo {
    @Inject
    EntityManager em;

    public void updateEmployee(Employee employee) {
        em.createQuery("update Employee set name = :name WHERE empId = :empID")
                .setParameter("name", employee.getName())
                .setParameter("empID", employee.getEmpId());;
    }

    public void deleteEmployee(long id) {
        em.createQuery("delete from Employee where empId = :empid")
                .setParameter("empid", id);
    }
    public void createEmployee(Employee employee){
        em.persist(employee);
    }
}
