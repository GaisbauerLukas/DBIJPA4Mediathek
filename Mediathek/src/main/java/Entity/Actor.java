package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorId;
    String name;
    @OneToMany(cascade = {CascadeType.ALL})
    List<ActorMovie> actorMovies;

    public Actor(){
    }


    public Actor(String name, List<ActorMovie> actorMovies) {
        this.name = name;
        this.actorMovies = actorMovies;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ActorMovie> getActorMovies() {
        return actorMovies;
    }

    public void setActorMovies(List<ActorMovie> actorMovies) {
        this.actorMovies = actorMovies;
    }
}
