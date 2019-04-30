import javax.persistence.*;

@Entity
@Table(name = "Users")
public class QueryObject {
    @Id @GeneratedValue
    @Column(name = "ID")
    private int id;
    @Column(name = "FirstName")
    private String FirstName;
    @Column(name = "LastName")
    private String LastName;
    @Column(name = "Email")
    private String Email;


    QueryObject(String FirstName, String LastName, String Email){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
    }
    QueryObject(){}

    public String getEmail() {
        return Email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }



    public void setEmail(String email) {
        Email = email;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.getFirstName() + ", " + this.getLastName() + ", " + this.getEmail();
    }
}
