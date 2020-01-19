package Entity;

import javax.persistence.Embeddable;

@Embeddable
public class ActorMovieID {
    private int actorId;
    private int movieId;

    public ActorMovieID(int actorId, int movieId) {
        this.actorId = actorId;
        this.movieId = movieId;
    }

    public ActorMovieID() {
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
