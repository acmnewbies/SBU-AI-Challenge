import com.mysql.cj.QueryResult;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;

public class MySQLTest {

    public static void main(String[] args) {
        HibernateTest hb = new HibernateTest();
        QueryObject p = hb.getUserFromBase(11);
        if( p!= null )
            System.out.println(p.toString());

    }

}