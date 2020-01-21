package Entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MovieLocationID implements Serializable {
    private int movieID;
    private int locationID;

    public MovieLocationID() {
    }
    public MovieLocationID(int movieID,int locationID){
        this.movieID = movieID;
        this.locationID = locationID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
}
