package com.company.hibernate.demo;

import com.company.hibernate.entity.Course;
import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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

            // create some courses
            Course course01 = new Course("I like java");
            Course course02 = new Course("I like c++");

            // add courses to instructor
            myInstructor.add(course01);
            myInstructor.add(course02);

            // save the courses
            session.save(course01);
            session.save(course02);

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
