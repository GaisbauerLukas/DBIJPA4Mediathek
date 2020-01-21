package Endpoint;

import Entity.Bill;
import Entity.Customer;
import Entity.Lend;
import Repos.BillRepo;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("app")
public class BillEndpoint {

    @Inject
    BillRepo billRepo;

    @Path("create")
    @POST
    public void create(Bill bill){
        billRepo.createBill(bill);
    }

    @Path("createByLend")
    @POST
    public void createByLend(Lend lend){
        billRepo.createBillOfLend(lend);
    }

    @Path("update")
    @PUT
    public void update(Bill bill){
        billRepo.updateBill(bill);
    }

    @Path("delete-{id}")
    @DELETE
    public void delete(@PathParam("id") int id){
        billRepo.deleteBill(id);
    }

    @Path("getBillOfCustomer")
    @GET
    public void getBillOfCustomer(Customer customer){
        billRepo.getBillByCustomer(customer);
    }
}
