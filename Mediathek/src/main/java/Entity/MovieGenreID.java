package Entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MovieGenreID implements Serializable {
    private int movieId;
    private int genreId;

    public MovieGenreID() {
    }

    public MovieGenreID(int movieId, int genreId) {
        this.movieId = movieId;
        this.genreId = genreId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
