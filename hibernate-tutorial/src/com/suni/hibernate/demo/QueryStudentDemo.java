package com.suni.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suni.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
				
		
		// create session
		Session session=factory.getCurrentSession();

		//use session object to save the java object
		try {
			
			
			//start transaction
			session.beginTransaction();
			
			//query all students
			List<Student> theStudent=session.createQuery("from Student").getResultList();
			
			//display student
			displayStudents(theStudent);
			
			//Query student based on last name
			theStudent=session.createQuery("from Student s Where s.lastName='K'").getResultList();
			//display student
			System.out.println("Student whose last name is K");
			displayStudents(theStudent);
			//commit the transaction
			System.out.println("Student object is commited");
			session.getTransaction().commit();
		} 
		
		finally{
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudent) {
		for(Student student :theStudent) {
			System.out.println(student);
		}
	}

}
