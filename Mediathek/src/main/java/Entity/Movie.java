package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int movieId;
    String name;
    @OneToMany
    List<ActorMovie> actorMovies;
    @OneToMany
    List<MovieLocation>movieLocations;
    @OneToMany
    List<MovieGenre>movieGenres;
    @ManyToOne
    Studio studio;

    public Movie(){}

    public Movie(String name, List<ActorMovie> actorMovies, List<MovieLocation> movieLocations, List<MovieGenre> movieGenres, Studio studio) {
        this.name = name;
        this.actorMovies = actorMovies;
        this.movieLocations = movieLocations;
        this.movieGenres = movieGenres;
        this.studio = studio;
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
