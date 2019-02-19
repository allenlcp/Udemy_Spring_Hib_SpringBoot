package com.company.hibernate.demo;

import com.comany.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // create a student object
            System.out.println("Creation 3 student object... ");
            Student tempStudent1 = new Student("John", "Doe", "john@company2.com");
            Student tempStudent2 = new Student("Mark", "Wallace", "mark@company1.com");
            Student tempStudent3 = new Student("Bonita", "Blue", "bonita@company5.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

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
