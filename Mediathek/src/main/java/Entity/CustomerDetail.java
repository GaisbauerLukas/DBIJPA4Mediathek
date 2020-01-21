package Entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CustomerDetail {
    @Id
    int CustomerId;

    String phoneNumber;
    String email;
    Date birthday;
    String favouriteMovie;
    String religion;

    public CustomerDetail(){

    }

    public CustomerDetail(int customerId, String phoneNumber, String email, Date birthday, String favouriteMovie, String religion) {
        CustomerId = customerId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthday = birthday;
        this.favouriteMovie = favouriteMovie;
        this.religion = religion;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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
