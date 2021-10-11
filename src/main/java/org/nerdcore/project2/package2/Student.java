package org.nerdcore.project2.package2;

public class Student {
    public String name;
    public double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "name:"+name+", gpa:"+gpa;
    }
}
