package DTO;

import Entity.Employee;
import Entity.Genre;
import Entity.MovieGenre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

public class GenreDTO {

    @PersistenceContext
    EntityManager em;

    String path = "../resources/Genre.csv";
    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Genre(Integer.parseInt(a[0]), a[1]))
                .forEach(em::merge);
    }

    public List<MovieGenre> getbyId(int id){
        List<MovieGenre> movieGenres = em.createQuery("select mg from MovieGenre mg where mg.getMovieGenreID.genreId = :id").setParameter("id", id).getResultList();
        return movieGenres;
    }
}
