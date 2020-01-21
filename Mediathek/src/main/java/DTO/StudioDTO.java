package DTO;

import Entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import java.util.List;

public class StudioDTO {
    int studioId;
    String studioName;
    List<Movie> movies;

    @PersistenceContext
    EntityManager em;

    public void readFromCSV(){

    }

    public StudioDTO() {
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
