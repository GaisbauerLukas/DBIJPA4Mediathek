package DTO;

import Entity.ActorMovie;
import Entity.MovieGenre;
import Entity.MovieLocation;
import Entity.Studio;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MovieDTO {
    int movieId;
    String name;
    List<ActorMovie> actorMovies;
    List<MovieLocation>movieLocations;
    List<MovieGenre>movieGenres;
    Studio studio;

    @PersistenceContext
    EntityManager entityManager;

    public MovieDTO() {
    }

    String path = "../resources/Bill.csv";
    public void readFromCSV(){

    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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

    public List<MovieLocation> getMovieLocations() {
        return movieLocations;
    }

    public void setMovieLocations(List<MovieLocation> movieLocations) {
        this.movieLocations = movieLocations;
    }

    public List<MovieGenre> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(List<MovieGenre> movieGenres) {
        this.movieGenres = movieGenres;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}
