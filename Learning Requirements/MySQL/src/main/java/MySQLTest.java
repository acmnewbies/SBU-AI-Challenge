import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;

public class MySQLTest {

    private static Connection connection;

    public static void main(String[] args) {

        try {
            //connectToDB();
            HibernateTest hb = new HibernateTest();
            hb.addProfile("m" , "m" , "s.com" , new Profile("m" , 10 ));
            //insertToDB("amirali", "monjar", "ami@g.com");
            //deleteFromDB("ID = 2");
            //Profile p= new Profile("r.sayadi" , 20 ,1);
            //writeBLOB(p);
            readFromDB(1);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void connectToDB() throws SQLException {

        String myUrl = "jdbc:mysql://localhost/java_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&serverTimezone=UTC&useSSL=false";
        connection = DriverManager.getConnection(myUrl, "amirali", "Ss@22214320");

    }

    private static void insertToDB(String firstName, String lastName, String email) throws SQLException {
        //String query = "INSERT INTO Users (FirstName , LastName , Email) Values ('"+ firstName +"','"+ lastName+ "','"+email +"');";

        String query = "INSERT INTO Users (FirstName , LastName , Email) values (?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, email);

        ps.execute();
        ps.close();

    }

    private static void deleteFromDB(String condition) throws SQLException{
        String query = "DELETE FROM Users WHERE " + condition;
        PreparedStatement ps = connection.prepareStatement(query);
        ps.execute();

    }

    private static void readFromDB(int id) throws SQLException  {

        PreparedStatement ps = null;
        String query = "SELECT * FROM Users";
        //String query = "SELECT * FROM Users WHERE ID = ?";
        ps = connection.prepareStatement(query);
        //ps.setInt(1, id);

        // execute select SQL stetement
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String userid = rs.getString("ID");
            String firstName = rs.getString("FirstName");
            String lastname = rs.getString("LastName");
            String email = rs.getString("Email");
            Profile profile = readBlob(rs);

            System.out.println("userid : " + userid);
            System.out.println("firstname : " + firstName);
            System.out.println("lastName : " + lastname);
            System.out.println("email : " + email);
            if (profile != null)
                System.out.println("Profile: \n\tName-->" + profile.firstname + "\n\tAge-->" + profile.age);
            System.out.println("---------------------");
        }
    }

    private static void writeBLOB(Profile profile) throws SQLException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(baos);
            out.writeObject(profile);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] byteObject = baos.toByteArray();

        String query = "UPDATE Users " + "SET Profiles= ? " + "WHERE ID = ? ";

        PreparedStatement ps = connection.prepareStatement(query);
        Blob blob = ps.getConnection().createBlob();
        blob.setBytes(1, byteObject);
        //ps.setObject(1 ,profile);
       // ps.setInt(2 , profile.id);
        ps.setBlob(1 , blob);
        ps.execute();
        ps.close();
    }


    private static Profile readBlob(ResultSet rs) throws SQLException{
        Blob p = rs.getBlob("Profiles");
        Profile profile=null;
        try {
            if (p!=null) {
                ObjectInputStream obj = new ObjectInputStream(p.getBinaryStream());
                profile = (Profile) obj.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return profile;
    }

}