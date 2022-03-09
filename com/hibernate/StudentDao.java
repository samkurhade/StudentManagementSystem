package com.hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.hibernate.util.HibernateUtils;

public class StudentDao {
	
	// Methods for CRUD Operations
	
	// 1 . Create/Save Student
	public static void saveStudent() {
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();
	        System.out.println("Enter the student details to save the student");
			Scanner sc = new Scanner(System.in);
			Student st = new Student();
			System.out.println("Enter the first name of the student :");
			st.setfName(sc.nextLine());
			System.out.println("Enter the last name of the student :");
			st.setlName(sc.nextLine());
			System.out.println("Enter the contact no of the student :");
			st.setContactNo(sc.nextLine());
			System.out.println("Enter the email of the student :");
			st.setEmail(sc.nextLine());
			System.out.println("Enter the city of the student :");
			st.setCity(sc.nextLine());
			

			
	        Transaction tx = session.beginTransaction();
	        
	        session.save(st);
	        tx.commit();
	        session.close();
//	        sessionFactory.close();
	        
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 2 . Get Student By ID
	public static void getStudentById() {
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();
			System.out.println("Enter the student details to get the student");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Id of the student");
			Student st = (Student)session.get(Student.class , sc.nextInt());
			System.out.println(st);
			
	        session.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 3 . Get All the Students
	public static void getAllStudents() {
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();

			System.out.println("Displaying all the student");
			
			// SQL Query
			String q = "select * from student_details";
			@SuppressWarnings("unchecked")
			NativeQuery<Object[]> nq = session.createSQLQuery(q);
			List<Object []> listOfStudents = nq.list();
			
			for(Object[] st1 : listOfStudents) {
				System.out.println(st1[0]+" : "+st1[4]+" : "+st1[5]+" : "+st1[3]);
			}
			
			
	        session.close();

	        
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 
	// 4 . Updating Student
	public static void updateStudent() {
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();
			System.out.println("Enter the student details to update the student");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the Id of the student");
			
			Student st = session.get(Student.class, sc.nextInt());
			
			System.out.println("Enter the first name of the student");
			st.setfName(sc.next());
//			System.out.println("Enter the last name of the student :");
//			st.setlName(sc.nextLine());
//			System.out.println("Enter the contact no of the student :");
//			st.setContactNo(sc.nextLine());
//			System.out.println("Enter the email of the student :");
//			st.setEmail(sc.nextLine());
//			System.out.println("Enter the city of the student :");
//			st.setCity(sc.nextLine());
			
		
	        Transaction tx = session.beginTransaction();
	        
	        session.update(st);
	        tx.commit();
	        
	        session.close();

	        
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 5 . Deleting Student
	public static void deleteStudent() {
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();
			System.out.println("Enter the student Id to delete the student");
	        Scanner sc = new Scanner(System.in);
	        Student st = new Student();
			System.out.println("Enter the Id of the student ");
			st.setId(sc.nextInt());
			
	        Transaction tx = session.beginTransaction();
	        
	        session.delete(st);
	        tx.commit();
	        session.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void closeSessionFactory() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		sessionFactory.close();
	}
	
}
