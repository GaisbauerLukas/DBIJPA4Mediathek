package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int studioId;
    String studioName;

    @OneToMany
    List<Movie> movies;

    public Studio(){}

    public Studio(String studioName, List<Movie> movies) {
        this.studioName = studioName;
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
