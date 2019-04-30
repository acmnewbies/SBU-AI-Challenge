import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class HibernateTest {


    private SessionFactory factory;

    HibernateTest(){
        try {
            //factory = new Configuration().configure().  buildSessionFactory();
            factory = new Configuration().configure().addAnnotatedClass(QueryObject.class).buildSessionFactory();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
//  Method to CREATE a user in the database
    public Integer addProfile(String firstname ,String lastname, String email, Profile profile){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer profileID = null;

        try {
            tx = session.beginTransaction();
            QueryObject queryObject = new QueryObject(firstname ,lastname ,email);
            profileID = (Integer) session.save(queryObject);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return profileID;
    }

//  Method to  READ all the employees
    public void iterateOnList( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Users").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                QueryObject qb = (QueryObject) iterator.next();
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//  Method to UPDATE salary for an employee
    public void updateEmployee(Integer EmployeeID, int salary ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Profile employee = (Profile)session.get(Profile.class, EmployeeID);
//            employee.setSalary( salary );
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//  Method to DELETE a user from the database
    public void deleteEmployee(Profile profile){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(profile);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
//  method to get a users column from DB
    public QueryObject getUserFromBase(int id){
        Session session = factory.openSession();
        Transaction tx = null;
        QueryObject qo = null;
        try {
            tx = session.beginTransaction();
            qo = session.get(QueryObject.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return qo;

    }

}


