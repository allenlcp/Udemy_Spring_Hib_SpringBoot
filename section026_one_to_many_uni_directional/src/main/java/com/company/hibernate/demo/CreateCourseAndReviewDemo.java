package com.company.hibernate.demo;

import com.company.hibernate.entity.Course;
import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import com.company.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();


        try{

            // start a transaction
            session.beginTransaction();

            // create a course
            Course myCourse = new Course("Intro to Java");

            // add some reviews
            myCourse.add(new Review("Very good"));
            myCourse.add(new Review("Average"));
            myCourse.add(new Review("Poor"));

            // save the source ... and leverage the cascade all...
            System.out.println("Saving the course");
            System.out.println(myCourse);
            System.out.println(myCourse.getReviews());
            session.save(myCourse);

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
