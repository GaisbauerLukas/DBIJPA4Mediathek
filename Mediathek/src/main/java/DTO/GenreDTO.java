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
    int genreId;
    String genre;
    List<MovieGenre>movieGenres;

    @PersistenceContext
    EntityManager em;

    public GenreDTO() {
    }

    String path = "../resources/Genre.csv";
    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new Genre(Integer.parseInt(a[0]), a[1], getbyId(Integer.parseInt(a[0]))))
                .forEach(em::merge);
    }

    public List<MovieGenre> getbyId(int id){
        List<MovieGenre> movieGenres = em.createQuery("select mg from MovieGenre mg where mg.getMovieGenreID.genreId = :id").setParameter("id", id).getResultList();
        return movieGenres;
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
