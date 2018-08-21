package com.dzone.java_enums__how_to_use_configurable_sorting_fields;

import java.util.ArrayList;
import java.util.Comparator;

public class MainJava8 {
	public static void main(String[] args) {
		// preparing some hard-coded data to keep code simple and focused.
		ArrayList<Student> studentList = new ArrayList<>();
		studentList.add(new Student(101, "Vijay", 24, 98));
		studentList.add(new Student(109, "Ajay", 27, 86));
		studentList.add(new Student(108, "Jai", 26, 49));
		studentList.add(new Student(106, "Ajay", 23, 45));
		studentList.add(new Student(104, "Jai", 26, 62));
		studentList.add(new Student(103, "Vijay", 23, 98));
		studentList.add(new Student(105, "Jai", 21, 54));
		System.out.println("Sorting by Name...");
		studentList.sort(Comparator.comparing(Student::getName));
		printStudentList(studentList);
		System.out.println("Sorting by Name and age (both ascending)...");
		studentList.sort(Comparator.comparing(Student::getName).thenComparing(Student::getAge));
		printStudentList(studentList);
		System.out.println("Sorting by Name and age (desc) and rollno...");
		studentList.sort(Comparator.comparing(Student::getName).thenComparing(Student::getAge).reversed().thenComparing(Student::getRollno));
		printStudentList(studentList);
		System.out.println("sorting by age...");
		studentList.sort(Comparator.comparing(Student::getAge));
		printStudentList(studentList);
		System.out.println("sorting by rollno in descending order...");
		studentList.sort(Comparator.comparing(Student::getRollno).reversed());
		printStudentList(studentList);
	}

	private static void printStudentList(ArrayList<Student> studentList) {
		studentList.forEach(System.out::println);
	}
}