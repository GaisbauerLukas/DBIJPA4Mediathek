package Endpoint;

import Entity.Actor;
import Entity.Lend;
import Entity.Location;
import Repos.LocationRepo;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("api/Location")
public class LocationEndpoint {

    @Inject
    LocationRepo locationRepo;

    @Path("create")
    @POST
    public void create(Location location) {
        locationRepo.createLocation(location);
    }

    @Path("update")
    @PUT
    public void update(Location location){
        locationRepo.updateLocation(location);
    }

    @Path("delete-{id}")
    @DELETE
    public void delete(@PathParam("id") int id){
        locationRepo.deleteLocation(id);
    }
}
