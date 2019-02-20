package com.company.hibernate.demo;

import com.company.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMaryStudentDemo {
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

            // get the student mary from the database
            int maryId = 2;
            Student maryStudent = session.get(Student.class, maryId);
            System.out.println("\nRetrieved student obj: " + maryStudent);
            System.out.println("Courses: " + maryStudent.getCourses());

            // delete mary
            session.delete(maryStudent);
            System.out.println("Deleted Mary as a student");

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
