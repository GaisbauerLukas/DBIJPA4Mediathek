package DTO;

import Entity.*;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

public class MovieDAO {


    @PersistenceContext
    EntityManager em;

    public MovieDAO() {

    }

    String path = "/csv/Movie.csv";
    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Movie(a[1], getActorMoviesbyId(Integer.parseInt(a[0])), getMovieLocationsbyId(Integer.parseInt(a[0])), getMovieGenresbyId(Integer.parseInt(a[0])), getStudiobyId(Integer.parseInt(a[2])), getLendbyId(Integer.parseInt(a[3])), getStorebyId(Integer.parseInt(a[4]))))
                .forEach(em::merge);
    }

    public List<ActorMovie> getActorMoviesbyId(int id){
        List<ActorMovie> actorMovies = em.createQuery("select am from ActorMovie am where am.actorMovieID.movieId = :id").setParameter("id", id).getResultList();
        return actorMovies;
    }

    public List<MovieLocation> getMovieLocationsbyId(int id){
        List<MovieLocation> movieLocations = em.createQuery("select ml from MovieLocation ml where ml.movieLocationID.movieID = :id").setParameter("id", id).getResultList();
        return movieLocations;
    }

    public List<MovieGenre> getMovieGenresbyId(int id){
        List<MovieGenre> movieGenres = em.createQuery("select mg from MovieGenre mg where mg.movieGenreID.movieId = :id").setParameter("id", id).getResultList();
        return movieGenres;
    }

    public Studio getStudiobyId(int id){
        Studio studio = (Studio)em.createQuery("select s from Studio s where s.studioId = :id").getSingleResult();
        return studio;
    }

    public Lend getLendbyId(int id){
        Lend lend = (Lend)em.createQuery("select l from Lend l where l.lendID = :id").setParameter("id", id).getSingleResult();
        return lend;
    }

    public Store getStorebyId(int id){
        Store store = (Store)em.createQuery("select s from Store s where s.storeId = :id").setParameter("id", id).getSingleResult();
        return store;
    }


}
