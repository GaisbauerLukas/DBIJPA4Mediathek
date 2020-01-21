package Endpoint;

import Entity.Actor;
import Entity.Lend;
import Repos.LendRepo;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("api")
public class LendEndpoint {
    @Inject
    LendRepo lendRepo;

    @Path("create")
    @POST
    public void create(Lend lend) {
        lendRepo.createLend(lend);
    }

    @Path("createLendByList")
    @POST
    public void create(List<Lend> lends){
        lendRepo.createLendsByList(lends);
    }

    @Path("update")
    @PUT
    public void update(Lend lend){
        lendRepo.updateLend(lend);
    }

    @Path("delete-{id}")
    @DELETE
    public void delete(@PathParam("id") int id){
        lendRepo.deleteLend(id);
    }

    @Path("getCostOfLend")
    @GET
    public void getCostOfLend(Lend lend){
        lendRepo.getCostOfLend(lend);
    }

    @Path("getCostOfLend-{id}")
    @GET
    public void getCostOfLend(@PathParam("id") int id){
        lendRepo.getCostOfLend(id);
    }
}
