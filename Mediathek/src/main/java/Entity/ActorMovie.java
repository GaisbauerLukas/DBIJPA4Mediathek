package Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ActorMovie {
    public ActorMovie(){

    }

    @EmbeddedId
    private ActorMovieID actorMovieID;

    public ActorMovie(ActorMovieID actorMovieID) {
        this.actorMovieID = actorMovieID;
    }

    public ActorMovieID getActorMovieID() {
        return actorMovieID;
    }

    public void setActorMovieID(ActorMovieID actorMovieID) {
        this.actorMovieID = actorMovieID;
    }
}
