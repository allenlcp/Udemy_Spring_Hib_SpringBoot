package com.company.hibernate.demo;

import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
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

            // find instructorDetail object
            int theId = 3;
            InstructorDetail myInstructorDetail = session.get(InstructorDetail.class,theId);
            System.out.println(myInstructorDetail);
            System.out.println(myInstructorDetail.getInstructor());

            // remove the associated object reference
            // break bi-directional link
            // delete instructorDetail object but setting/pointing it to null
            myInstructorDetail.getInstructor().setInstructorDetail(null);

            System.out.println("Deleting instructorDetail obj:  " + myInstructorDetail);
            session.delete(myInstructorDetail);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // handle connection leak issue
            session.close();
            factory.close();
        }


    }
}
