package Endpoint;

import Entity.Actor;
import Entity.Studio;
import Repos.StudioRepo;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("api")
public class StudioEndpoint {
    @Inject
    StudioRepo studioRepo;

    @Path("create")
    @POST
    public void create(Studio studio) {
        studioRepo.createStudio(studio);
    }

    @Path("update")
    @PUT
    public void update(Studio studio){

        studioRepo.updateStudio(studio);
    }

    @Path("delete-{id}")
    @DELETE
    public void delete(@PathParam("id") int id){
        studioRepo.deleteStudio(id);
    }
}
