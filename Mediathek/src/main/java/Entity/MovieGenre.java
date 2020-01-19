package Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class MovieGenre {
    public MovieGenre(){}

    @EmbeddedId
    private MovieGenreID movieGenreID;

    public MovieGenre(MovieGenreID movieGenreID) {
        this.movieGenreID = movieGenreID;
    }

    public MovieGenreID getMovieGenreID() {
        return movieGenreID;
    }

    public void setMovieGenreID(MovieGenreID movieGenreID) {
        this.movieGenreID = movieGenreID;
    }
}
