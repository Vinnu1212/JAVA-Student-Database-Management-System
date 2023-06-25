package com.sortinglogic;

import java.util.Comparator;

import com.jspider.Student;

public class StudentSortById implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		
		return x.getId().compareTo(y.getId());
	}

}
