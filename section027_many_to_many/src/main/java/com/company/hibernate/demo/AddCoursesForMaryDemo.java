package com.company.hibernate.demo;

import com.company.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMaryDemo {
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

            // create more courses
            Course course01 = new Course("Intro to Android");
            Course course02 = new Course("Intro to HTML");
            Course course03 = new Course("Intro to CSS");


            // add student to courses
            course01.addStudent(maryStudent);
            course02.addStudent(maryStudent);
            course03.addStudent(maryStudent);

            // save the courses
            System.out.println("\nSaving the courses ...");
            session.save(course01);
            session.save(course02);
            session.save(course03);


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
