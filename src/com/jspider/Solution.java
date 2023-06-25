package com.jspider;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		//	Menu driven program	
		//	upcasting	
		//	switch case	
		//	System.exit(0	 
		//	infinite loop >> while(true)
		//		to accept input from user
		Scanner sc=new Scanner(System.in);
		

		//		upcasting  for achieving abstraction
		StudentManagementSystem sms=new StudentManagementImpl();
		
		System.out.println("welcome to menu driven program");
		while(true) {
		System.out.println("1:add Students\n2:display student\n3:display all students\n4:remove student");
		System.out.println("5:remove all student\n6:update students\n7:count students\n8:sort students");
		System.out.println("9:Exit\nEnter choice");
		int choice=sc.nextInt();
 
		switch(choice) {

		case 1:
			sms.addStudent();
			break;
		case 2:
			sms.displayStudent();
			break;
		case 3:
			sms.displayAllStudent();
			break;
		case 4:
			sms.removeStudent();
			break;
		case 5:
			sms.removeAllStudent();
			break;
		case 6:
			sms.updateStudent();
			break;

		case 7:
			sms.countStudent();
			break;
		case 8:
			sms.sortStudent();
			break;
		case 9:
			System.out.println("Thank You!!!");
			System.exit(0);

		default :
//			try {
//				throw new InvalidChoiceException("Invalid choice");
//			}
//			catch(Exception e) {
//				System.out.println(e.getMessage());
//			}
			try {
			throw new InvalidChoiceException("invalid choice");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}


	}


}
	
}