package com.company.hibernate.demo;

import com.comany.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // *****************************
            //  Example 1
            // *****************************
            int studentId = 1;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on id: pk
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Get complete: " + myStudent);

            System.out.println("Updating student");
            myStudent.setFirstName("Scooby");

            // commit transaction
            session.getTransaction().commit();

            // *****************************
            //  Example 2
            // *****************************
            session = factory.getCurrentSession();
            session.beginTransaction();

            // update email for all students
            System.out.println("Update email for all students");
            session.createQuery("UPDATE Student SET email='foot@gmail.com'").executeUpdate();


            // commit the transaction
            session.getTransaction().commit();


            System.out.println("Done!");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }


    }
}
