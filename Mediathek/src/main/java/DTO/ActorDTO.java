package DTO;

import Entity.Actor;
import Entity.ActorMovie;
import Entity.Bill;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.QueryParam;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

public class ActorDTO {
    int actorId;
    String name;
    List<ActorMovie> actorMovies;

    public ActorDTO() {
    }

    @PersistenceContext
    EntityManager em;

    String path = "../resources/csv/Actor.csv";

    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Actor(Integer.parseInt(a[0]), a[1], getbyId(Integer.parseInt(a[0]))))
                .forEach(em::merge);
    }

    public List<ActorMovie> getbyId(int ID){
        List<ActorMovie> actorMovies = em.createQuery("select a from ActorMovie a where a.actorMovieId.actorId = :ID").setParameter("ID", ID).getResultList();
        return actorMovies;
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
