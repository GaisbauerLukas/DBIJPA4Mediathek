package DTO;

import Entity.Bill;
import Entity.Employee;
import Entity.Movie;
import Entity.Studio;

import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

public class StudioDTO {
    int studioId;
    String studioName;
    List<Movie> movies;

    @PersistenceContext
    EntityManager em;

    String path = "../resources/Studio.csv";
    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Studio(a[1], getMoviesbyId(a[2].split(","))))
                .forEach(em::merge);
    }

    public StudioDTO() {
    }

    public List<Movie> getMoviesbyId(String[] ids){
        List<Movie> movies = null;
        for(int i = 0; i < ids.length; i++){
            movies.add((Movie)em.createQuery("select m from Movie m where m.movieId = :id").setParameter("id", Integer.parseInt(ids[i])).getSingleResult());
        }

        return movies;
    }

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
