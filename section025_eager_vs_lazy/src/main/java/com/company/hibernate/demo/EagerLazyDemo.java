package com.company.hibernate.demo;

import com.company.hibernate.entity.Course;
import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
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

            // get the instructor form the db
            int theId = 1;
            Instructor myInstructor = session.get(Instructor.class, theId);
            System.out.println("Retrieved instructor: " + myInstructor);

            // Option 1:
            // Pre-loading the data in memory before closing session
            // We this can access the data after session closed
            System.out.println("Getting courses: " + myInstructor.getCourses());


            // commit transaction
            session.getTransaction().commit();

            // close session
            session.close();
            System.out.println("\nSession is now closed\n");

            // option 1: call getter method while session is open
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
