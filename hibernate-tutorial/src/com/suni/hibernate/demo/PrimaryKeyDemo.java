package com.suni.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suni.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object");
			
			Student theStudent1=new Student("Ramesh","K","kramesh@famil.com");
			Student theStudent2=new Student("Mahesh","S","smahesh@famil.com");
			Student theStudent3=new Student("Suresh","U","usuresh@famil.com");
			
			session.beginTransaction();
			
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		

	}

}
