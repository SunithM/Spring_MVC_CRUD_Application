package com.suni.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suni.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
				
		
		// create session
		Session session=factory.getCurrentSession();

		//use session object to save the java object
		try {
			System.out.println("Creating a new student object");
			
			//create student class
			Student tempStudent=new Student("Rahul","K","ksunith@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student");
			session.save(tempStudent);
			
			//commit the transaction
			System.out.println("Student object is commited");
			session.getTransaction().commit();
		} 
		
		finally{
			factory.close();
		}

	}

}
