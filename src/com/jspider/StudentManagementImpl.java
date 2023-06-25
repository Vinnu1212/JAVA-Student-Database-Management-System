package com.jspider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customexception.StudentNotFoundException;
import com.sortinglogic.StudentSortByAge;
import com.sortinglogic.StudentSortById;
import com.sortinglogic.StudentSortByMarks;
import com.sortinglogic.StudentSortByName;

/**
 * 
 * @author udaya
 * @since 2022
 * 
 * we are adding implementation for 8 abstract methods StudentManagementSystem
 *
 */

public class StudentManagementImpl implements StudentManagementSystem {


	Map<String,Student> db=new LinkedHashMap<String,Student>();
	Scanner sc=new Scanner(System.in);



	@Override
	public void addStudent() {
		System.out.println("enter age");
		int age=sc.nextInt();
		System.out.println("enter name");
		String name=sc.next();
		System.out.println("enter marks");
		int marks=sc.nextInt();

		Student s=new Student(age,name,marks);

		db.put(s.getId(), s);
		System.out.println("student record inserted successfully");
		System.out.println(" your student id is "+ s.getId());

	}

	@Override
	public void displayStudent() {
		System.out.println("Enter student id");
		String id=sc.next();

		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Student obj=db.get(id);
			System.out.println("Id: "+obj.getId());
			System.out.print(" Name: "+obj.getName());
			System.out.print(" Age: "+obj.getAge());
			System.out.print(" Marks: "+obj.getMarks());
		}
		else {
			try {
				throw new StudentNotFoundException(" student records not available ");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}


	}

	@Override
	public void displayAllStudent() {
		Set<String> keys=db.keySet();
		System.out.println(" Student records are as follows ");
		System.out.println("-------------");
		if(db.size()!=0) {
			for(String key:keys) {
				System.out.println(db.get(key)); 

			}
		}
		else {
			try {
				throw new StudentNotFoundException(" student records not available ");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeStudent() {
		//		aceept thr id
		//String id=sc.next().toUpperCase();
		System.out.println("Enter student id");
		String id=sc.next();
		//		uppercase
		id=id.toUpperCase();

		//containskey
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student records deleted successfully");

		}
		else {

			try {
				throw new StudentNotFoundException(" student records not available ");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}




	}

	@Override
	public void removeAllStudent() {
		System.out.println("student record available"+db.size());
		db.clear();
		System.out.println("all student records deleted successfully");





	}

	@Override
	public void updateStudent() {
		System.out.println("Enter student id");
		String id=sc.next();

		id=id.toUpperCase();

		if(db.containsKey(id)) {
			Student	 std=db.get(id);

			System.out.println("1:Update Name\n2:Update Age\n3:Update Marks");
			System.out.println("Enter choice");
			int choice=sc.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter name:");
				String name=sc.next();
				std.setName(name); //std.setName(scan.next());
				System.out.println("Name updated successfully");
				break;
			case 2:
				System.out.println("Enter age:");
				int age=sc.nextInt();
				std.setAge(age); //std.setName(scan.next());
				System.out.println("Age updated successfully");

				break;
			case 3:
				System.out.println("Enter marks:");
				int marks=sc.nextInt();
				std.setMarks(marks); //std.setName(scan.next());
				System.out.println("Marks updated successfully");
				break;
			default :
				try {
					throw new InvalidChoiceException("invalid choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}



			}

		}




	}

	@Override
	public void countStudent() {
		System.out.println(" total number of student records "+db.size());


	}

	@Override
	public void sortStudent() {
	/**
	 * convert map into set
	 * keys are student Id and datatype is String
	 */
		Set<String> keys=db.keySet();

		
		/**
		 * Achieving upcasting between List & ArrayList
		 * list can store student objects
		 */
		List<Student> l=new ArrayList<Student>();
		for(String key:keys) {
			l.add(db.get(key));   //adding student objects from map to list
		}
		System.out.println("1:Sort By Id\n2:Sort By Name");
		System.out.println("3:Sort By Age\n4:Sort By Marks\nEnter Choice:");

		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(l,new StudentSortById());
			display(l);
			
			break;
		case 2:
			Collections.sort(l,new StudentSortByName());
			display(l);
			break;
		case 3:
			Collections.sort(l,new StudentSortByAge());
			display(l);
			break;
		case 4:
			Collections.sort(l,new StudentSortByMarks());
			display(l);
			break;
		default:
			try {
				throw new InvalidChoiceException("invalid choice");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}
}
	private static void display(List<Student> list) {
		for(Student s:list) {
			System.out.println(s);
		}
	}
	

}
