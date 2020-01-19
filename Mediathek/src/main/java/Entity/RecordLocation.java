package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class RecordLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int recLocId;
    String city;
    String country;
    @ManyToOne
    List<MovieLocation>movieLocations;

    public int getRecLocId() {
        return recLocId;
    }

    public void setRecLocId(int recLocId) {
        this.recLocId = recLocId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<MovieLocation> getMovieLocations() {
        return movieLocations;
    }

    public void setMovieLocations(List<MovieLocation> movieLocations) {
        this.movieLocations = movieLocations;
    }
}
