package com.company.hibernate.demo;

import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{

            // create the objects
            Instructor tempInstructor = new Instructor("Steven","Ted", "steven@company.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/steven", "Basketball");

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction
            session.beginTransaction();

            // save the instructor
            // CascadeType.ALL will save both objects at the same time
            session.save(tempInstructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }


    }
}
