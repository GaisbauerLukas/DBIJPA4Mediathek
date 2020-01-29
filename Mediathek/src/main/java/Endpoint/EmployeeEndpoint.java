package Endpoint;

import Entity.Actor;
import Entity.Employee;
import Repos.EmplyoeeRepo;

import javax.inject.Inject;
import javax.ws.rs.*;
@Path("Employee")
public class EmployeeEndpoint {

    @Inject
    EmplyoeeRepo emplyoeeRepo;

    @Path("create")
    @POST
    public void create(Employee employee) {
        emplyoeeRepo.createEmployee(employee);
    }

    @Path("update")
    @PUT
    public void update(Employee employee){
        emplyoeeRepo.updateEmployee(employee);
    }

    @Path("delete-{id}")
    @DELETE
    public void delete(@PathParam("id") int id){
        emplyoeeRepo.deleteEmployee(id);
    }
}
