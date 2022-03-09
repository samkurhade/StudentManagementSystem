package com.hibernate;

import java.util.Scanner;

import com.hibernate.util.HibernateUtils;


//import java.io.*;

public class App extends StudentDao
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started......." );
        boolean isTrue = true;
        
		Scanner sc1 = new Scanner(System.in);
        while(isTrue) {	
        	
            System.out.println("Enter choice between 1 - 5 : \n1 to save student \n2 to get student by id \n3 to get all the student \n4 to update student \n5 to delete student \n6 to exit");
            System.out.println("Enter your choice :");
            int choice = sc1.nextInt();
        	switch (choice) {
			case 1:
				StudentDao.saveStudent();
				break;
			case 2:
				StudentDao.getStudentById();
				break;
			case 3:
				StudentDao.getAllStudents();
				break;
			case 4:
				StudentDao.updateStudent();
				break;
			case 5:
				StudentDao.deleteStudent();
				break;
			case 6:
				StudentDao.closeSessionFactory();
				System.out.println("Project has been ended.......");
				isTrue = false;
				break;
			default:
				System.out.println("Please enter choice between 1 - 6");
				
			}
        	
        	
        }
        
        
        
    }
}
