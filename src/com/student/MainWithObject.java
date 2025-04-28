package com.student;

public class MainWithObject {

    public static void main(String[] args) {
        System.out.println("***** Student Management System ****");
        Student s1 = new Student("Kunal",30,"S-1");
        s1.enrollCourse("Java");
        //s1.printStudentInfo();
        s1.printStudentInfo();

        Student s2 = new Student("Sameer", 25, "S-2");
        s2.enrollCourse("DevOps");
        s2.printStudentInfo();

        Student s3 = new Student("Ganesh", 30, "S-3");
        s3.enrollCourse("DSA");
        s3.printStudentInfo();
    }
}
