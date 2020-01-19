package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int genreId;
    String genre;
    @OneToMany
    List<MovieGenre>movieGenres;

    public Genre(){}

    public Genre(String genre, List<MovieGenre> movieGenres) {
        this.genre = genre;
        this.movieGenres = movieGenres;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<MovieGenre> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(List<MovieGenre> movieGenres) {
        this.movieGenres = movieGenres;
    }
}
