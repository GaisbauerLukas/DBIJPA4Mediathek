package Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ActorMovie {
    public ActorMovie(){

    }

    @EmbeddedId
    private ActorMovieID actorMovieId;

    public ActorMovie(ActorMovieID actorMovieID) {
        this.actorMovieId = actorMovieID;
    }

    public ActorMovieID getActorMovieId() {
        return actorMovieId;
    }

    public void setActorMovieId(ActorMovieID actorMovieId) {
        this.actorMovieId = actorMovieId;
    }
}
