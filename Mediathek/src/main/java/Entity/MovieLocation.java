package Entity;

import javax.persistence.Entity;

@Entity
public class MovieLocation {
    RecordLocation recordLocation;
    Movie movie;
}
