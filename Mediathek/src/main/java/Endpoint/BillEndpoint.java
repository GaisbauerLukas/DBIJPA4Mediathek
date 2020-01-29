package Endpoint;

import Entity.Bill;
import Entity.Customer;
import Entity.Lend;
import Repos.BillRepo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("Bill")
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

    @Path("delete/{id}")
    @DELETE
    public void delete(@PathParam("id") int id){
        billRepo.deleteBill(id);
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Bill getById(@PathParam("id") int id){
        return billRepo.getBillById(id);
    }

    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bill> getBills(){
        return billRepo.getBills();
    }

    @Path("getBillOfCustomer/{cid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getBillOfCustomer(@PathParam("cid") int id){
        billRepo.getBillByCustomer(id);
    }
}
