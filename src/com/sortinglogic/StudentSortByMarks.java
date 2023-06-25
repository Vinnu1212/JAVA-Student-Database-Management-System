package com.sortinglogic;

import java.util.Comparator;

import com.jspider.Student;

public class StudentSortByMarks implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		
		return x.getMarks()-y.getMarks();
	}

}
