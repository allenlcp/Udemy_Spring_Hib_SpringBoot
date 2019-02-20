package com.company.hibernate.demo;

import com.company.hibernate.entity.Course;
import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{

            // start a transaction
            session.beginTransaction();

            // option 2: Hibernate query with HQL
            // get the instructor form the db
            int theId = 1;
            Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i " +
                                                             "JOIN FETCH i.courses " +
                                                             "WHERE i.id =:theInstructorId", Instructor.class);
            // set parameter on query
            query.setParameter("theInstructorId", theId);

            // execute query and get instructor
            Instructor myInstructor = query.getSingleResult();

            System.out.println("Retrieved instructor: " + myInstructor);


            // commit transaction
            session.getTransaction().commit();

            // close session
            session.close();
            System.out.println("\nSession is now closed\n");

            // option 2:
            // get courses from the instructor
            System.out.println("Getting courses: " + myInstructor.getCourses());


            System.out.println("Done!");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }


    }
}
