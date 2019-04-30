public class QueryObject {

    private String FirstName;
    private String LastName;
    private String Email;
    private int id;


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
}
