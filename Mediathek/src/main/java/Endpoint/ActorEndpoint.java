package Endpoint;

import Entity.Actor;
import Repos.ActorRepo;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("api")
public class ActorEndpoint {

        @Inject
        ActorRepo actorRepo;

        @Path("create")
        @POST
        public void create(Actor actor) {
            actorRepo.createActor(actor);
        }

        @Path("update")
        @PUT
        public void update(Actor actor){
            actorRepo.updateActor(actor);
        }

        @Path("delete/{id}")
        @PUT
        public void delete(@PathParam("id") int id){
            actorRepo.deleteActor(id);
        }
}
