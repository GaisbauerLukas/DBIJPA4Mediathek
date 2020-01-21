package Endpoint;

import Entity.Actor;
import Entity.Bill;
import Entity.Customer;
import Entity.Lend;
import Repos.CustomerRepo;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("api/Customer")
public class CustomerEndpoint {
    @Inject
    CustomerRepo customerRepo;

    @Path("create")
    @POST
    public void create(Customer customer){
        customerRepo.createCustomer(customer);
    }


    @Path("update")
    @PUT
    public void update(Customer customer){
        customerRepo.updateCustomer(customer);
    }

    @Path("delete-{id}")
    @DELETE
    public void delete(@PathParam("id") int id){
        customerRepo.deleteCustomer(id);
    }
}
