package Endpoint;

import Entity.Actor;
import Entity.Genre;
import Entity.Store;
import Repos.StoreRepo;

import javax.inject.Inject;
import javax.ws.rs.*;
@Path("Store")
public class StoreEndpoint {

    @Inject
    StoreRepo storeRepo;

    @Path("create")
    @POST
    public void create(Store store) {
        storeRepo.createStore(store);
    }

    @Path("update")
    @PUT
    public void update(Store store){
        storeRepo.updateStore(store);
    }

    @Path("delete-{id}")
    @DELETE
    public void delete(@PathParam("id") int id){
        storeRepo.deleteStore(id);
    }

    @Path("GetCustomersOfStore")
    @GET
    public void getCustomers(Store store){
        storeRepo.getCustomersOfStore(store);
    }
    @Path("GetMoviesOfStore")
    @GET
    public void getMovies(Store store){
        storeRepo.getMoviesOfStore(store);
    }


}
