package com.company.hibernate.demo;

import com.company.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteJavaCourseDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();


        try{

            // start a transaction
            session.beginTransaction();

            // get the course to be deleted
            int theId = 10;
            Course myCourse = session.get(Course.class, theId);

            // delete the course
            System.out.println("Deleting course: " + myCourse);
            session.delete(myCourse);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }


    }
}
