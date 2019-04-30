import java.io.Serializable;

public class Profile implements Serializable {

    Profile(String firstname , int age ){
        this.age = age;
        this.firstname = firstname;
    }
    Profile(String firstname ,String lastname, int age ){
        this(firstname,age);
        this.lastname = lastname;
    }

    String firstname;
    String lastname;
    int age;

}
