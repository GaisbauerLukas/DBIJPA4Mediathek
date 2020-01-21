package Entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieLocation {

    @EmbeddedId
    MovieLocationID movieLocationID;

    public MovieLocation() {
    }
    public MovieLocation(MovieLocationID movieLocationID){
        this.movieLocationID = movieLocationID;
    }

    public MovieLocationID getMovieLocationID() {
        return movieLocationID;
    }

    public void setMovieLocationID(MovieLocationID movieLocationID) {
        this.movieLocationID = movieLocationID;
    }
}
