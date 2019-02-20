package com.company.hibernate.demo;

import com.company.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {
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

            // create a course
            Course myCourse = new Course("Intro to C#");

            // save the source ... and leverage the cascade all...
            System.out.println("\nSaving the course");
            session.save(myCourse);
            System.out.println("Save the couse: " + myCourse);

            // create the students
            Student student1 = new Student("John", "Doe", "john@gmail.com");
            Student student2 = new Student("Amy", "Republic", "amy@gmail.com");

            // add students to the course
            myCourse.addStudent(student1);
            myCourse.addStudent(student2);

            // save the students
            System.out.println("\nSaving students");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved students: " + myCourse.getStudents());

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
