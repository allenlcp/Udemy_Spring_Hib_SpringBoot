package com.company.hibernate.demo;

import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
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
            // start a transaction
            session.beginTransaction();

            // get instructor by primary key/id
            int theId = 1;
            Instructor myInstructor = session.get(Instructor.class,theId);

            System.out.println(myInstructor);

            // delete the instructor
            if (myInstructor != null){
                System.out.println("Deleting: " + myInstructor);

                // Will ALSO delete associated details objects
                session.delete(myInstructor);
            }

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
