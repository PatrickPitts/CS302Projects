package org.nerdcore.project2.package2;

import java.util.*;

/**
 * Project: Project 2
 * Completion time: 1 Hour
 *
 * Honor Code: "I pledge that I have neither given nor received help from anyone
 * other than the instructor or the TAs for all program components included here."
 */

public class Driver {

    static Comparator<Student> byNameLength = new Comparator<Student>() {
        @Override
        public int compare(Student student, Student t1) {
            return student.name.length() - t1.name.length();
        }
    };

    static Comparator<Student> byGPA = new Comparator<Student>() {
        @Override
        public int compare(Student student, Student t1) {
            double diff = student.gpa - t1.gpa;
            if(diff > 0.0){
                return 1;
            } else if (diff < 0.0){
                return -1;
            }
            return 0;
        }
    };

    public static void main(String[] args) {
        List<Student> students = new LinkedList<>();
        students.add(new Student("Alice", 4.0));
        students.add(new Student("Charlie", 2.5));
        students.add(new Student("Nick", 3.98));
        students.add(new Student("Bob",2.9));
        students.add(new Student("Arnold", 1.12));
        students.add(new Student("Zaphod",4.00));
        students.add(new Student("Patrick", 4.01));

        System.out.println("Sorting 'students' LinkedList by length of Student.name field, using the Collections.sort() static method with a custom Comparator implementation:");
        Collections.sort(students, byNameLength);
        System.out.println(Arrays.toString(students.toArray()));
        System.out.println();
        
        System.out.println("Sorting 'students' LinkedList by Student.gpa value, using the Collections.sort() static method with a custom Comparator implementation:");
        Collections.sort(students, byGPA);
        System.out.println(Arrays.toString(students.toArray()));
        System.out.println();

        System.out.println("Copying 'students' LinkedList to 'studentArray' Array object...");
        Student[] studentArray = students.toArray(new Student[0]);
        System.out.println("Sorting 'studentArray' Array by length of Student.name field, using the Arrays.sort() static method with a custom Comparator implementation:");
        Arrays.sort(studentArray, byNameLength);
        System.out.println(Arrays.toString(studentArray));

    }

}
