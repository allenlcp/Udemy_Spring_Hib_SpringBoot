package com.company.hibernate.demo;

import com.comany.demo.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@Slf4j
public class QueryStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{

            // start a transaction
            session.beginTransaction();

            // query student ***************************
            List<Student> theStudents = session.createQuery("FROM Student").list();

            // display the students
            displayStudents(theStudents);

            // query students: lastName='Doe' ***************************
            theStudents = session.createQuery("FROM Student s WHERE s.lastName='Doe'").list();

            // display the students
            System.out.println("\n\nStudents who have last name of Doe");
            displayStudents(theStudents);


            // query students: lastName-'Doe' OR firstName='Daffy' ***************************
            theStudents = session.createQuery("FROM Student s WHERE s.lastName='Doe' OR s.firstName='Daffy'").list();

            // display the students
            System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
            displayStudents(theStudents);

            // query students where email like '%company1.com' ***************************
            theStudents = session.createQuery("FROM Student s WHERE s.email LIKE '%company1.com'").list();

            // display the students
            System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
            displayStudents(theStudents);


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }


    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent: theStudents){
            System.out.println(tempStudent);
        }
    }
}
