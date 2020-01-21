package DTO;

import Entity.Actor;
import Entity.CustomerDetail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Date;
import java.time.LocalDate;

public class CustomerDetailDTO {
    int CustomerId;

    String phoneNumber;
    String email;
    LocalDate birthday;
    String favouriteMovie;
    String religion;


    @PersistenceContext
    EntityManager em;

    public CustomerDetailDTO() {
    }

    String path = "../resources/csv/Actor.csv";

    public void readFromCSV(){
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(path), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> new CustomerDetail(Integer.parseInt(a[0]), a[1], a[2], LocalDate.parse(a[3]), a[4], a[5]))
                .forEach(em::merge);
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getFavouriteMovie() {
        return favouriteMovie;
    }

    public void setFavouriteMovie(String favouriteMovie) {
        this.favouriteMovie = favouriteMovie;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }
}
