package com.student;

import java.util.*;

public class MainWithScanner {

    private static List<Student> studentList;

    public static void main(String[] args) {
        System.out.println("***** Student Management System ****");

        studentList = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name....");
        String name = scanner.next();
        System.out.println("You have entered the name " + name);

        System.out.println("Enter student Age....");
        int age = scanner.nextInt();
        System.out.println("Student age is "+age);




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
