package Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int movieId;
    String name;
    @OneToMany(cascade = {CascadeType.ALL})
    List<ActorMovie> actorMovies;
    @OneToMany(cascade = {CascadeType.ALL})
    List<MovieLocation>movieLocations;
    @OneToMany(cascade = {CascadeType.ALL})
    List<MovieGenre>movieGenres;
    @ManyToOne(cascade = {CascadeType.ALL})
    Studio studio;
    @OneToOne(cascade = {CascadeType.ALL})
    Lend lend;
    @ManyToOne(cascade = {CascadeType.ALL})
    Store store;

    public Movie(){}

    public Movie(String name, List<ActorMovie> actorMovies, List<MovieLocation> movieLocations, List<MovieGenre> movieGenres, Studio studio, Lend lend, Store store) {
        this.name = name;
        this.actorMovies = actorMovies;
        this.movieLocations = movieLocations;
        this.movieGenres = movieGenres;
        this.studio = studio;
        this.lend = lend;
        this.store = store;
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

    public Lend getLend() {
        return lend;
    }

    public void setLend(Lend lend) {
        this.lend = lend;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
