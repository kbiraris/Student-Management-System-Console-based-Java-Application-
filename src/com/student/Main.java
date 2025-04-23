package com.student;

public class Main {

    public static void main(String[] args) {
        System.out.println("***** Student Management System ****");
        Student s1 = new Student("Kunal B",30,"S-1");
        s1.enrollCourse("Java");
        s1.enrollCourse("Java");
        s1.printStudentInfo();
    }
}
