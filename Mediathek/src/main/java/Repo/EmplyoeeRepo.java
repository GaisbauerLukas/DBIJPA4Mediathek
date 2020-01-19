package Repo;

import Entity.Employee;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class EmplyoeeRepo {
    @Inject
    EntityManager em;

    public void updateEmployee(Employee employee) {
        em.createQuery("update Employee set name = :name, store = :store where employee.empId = :id")
                .setParameter("name", employee.getName())
                .setParameter("store", employee.getStore())
                .setParameter("id", employee.getEmpId());
    }

    public void deleteEmployee(long id) {
        em.createQuery("delete from Employee where Employee.empiId = :empid")
                .setParameter("empid", id);
    }
}
