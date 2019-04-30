import java.io.Serializable;

public class Profile implements Serializable {

    Profile(String firstname , int age , int id){
        this.age = age;
        this.firstname = firstname;
        this.id = id;
    }
    Profile(String firstname ,String lastname, int age , int id){
        this(firstname,age,id);
        this.lastname = lastname;
    }

    String firstname;
    String lastname;
    int age;
    int id;

}
