package com.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainWithList {

    private static List<Student> studentList;
    public static void main(String[] args) {
        System.out.println("***** Student Management System ****");

        studentList = new ArrayList<Student>();

        Student s1 = new Student("Kunal",30,"S-1");
        s1.enrollCourse("Java");
        //s1.printStudentInfo();

        Student s2 = new Student("Sameer", 25, "S-2");
        s2.enrollCourse("DevOps");
        //s2.printStudentInfo();

        Student s3 = new Student("Ganesh", 30, "S-3");
        s3.enrollCourse("DSA");
        //s3.printStudentInfo();

        Student s4 = new Student("Aman", 32, "S-4");
        s3.enrollCourse("DevOps");
        //s3.printStudentInfo();

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);

        Student result = findStudentById("S-1");
        System.out.println("Find student by id " + result);

        sortByName();
    }
    public static Student findStudentById(String studentId){
        Student result = null;
        try {
            result = studentList
                    .stream()
                    .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No data Found"));
        }catch (RuntimeException e){
        System.err.println("Student with ID " + studentId + " not found");
        }
        return result;
    }

    private static void sortByName(){
        //code written in lambda expression its same as  code written in after 6 lines
        //Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Student> studentNameComparator = new Comparator<Student>(){
            @Override // auto generated method
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(studentList, studentNameComparator);
        //studentList.sort(studentNameComparator);
        System.out.println(studentList);
    }
}
