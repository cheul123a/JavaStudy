package chapter10;

import java.util.Comparator;

import chapter10.ComparatorExample.Student;

public class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		System.out.println("2");
		return Integer.compare(o1.sno, o2.sno);
		
	}

	

	
}
