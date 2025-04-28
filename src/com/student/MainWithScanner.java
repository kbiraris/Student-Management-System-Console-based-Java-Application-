package com.student;

import java.util.*;

public class MainWithScanner {

    private static List<Student> studentList;
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("***** Student Management System ****");
        studentList = new ArrayList<Student>();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option.....");
            System.out.println("1. Register a Student");
            System.out.println("2. Find student with StudentId");
            System.out.println("3. List all Student information");
            System.out.println("4. List Student information in sorted order");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    enrollStudent();
                    break;
                case 2:
                    findStudentById();
                    break;
                case 3:
                    printAllStudentData();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid option selected..... select 1 to 5");
            }
        }
    }

    private static void exit() {
        System.out.println("Exiting the system... Goodbye!");
        System.exit(0);
    }

    private static void printAllStudentData() {
        if (!studentList.isEmpty()) {
            System.out.println("---------PRINTING STUDENT DATA--------");
            for (Student student : studentList) {
                student.printStudentInfo();
                System.out.println("--------------------");
            }
        }else{
            System.err.println("Student list is empty.... no student record found");
        }
    }

    private static void enrollStudent() {
        System.out.println("Enter Student name");
        String studentName = scanner.next();

        System.out.println("Enter Student Age");
        int studentAge = scanner.nextInt();

        System.out.println("Enter Student Id");
        String studentId = scanner.next();

        Student newStudent = new Student(studentName, studentAge, studentId);
        studentList.add(newStudent);
        System.out.println("Student added successfully");

        while (true) {
            System.out.println("Enter course to enroll......else enter Done to exit");
            String course = scanner.next();
            if(course.equalsIgnoreCase("Done")){
                break;
            }
            newStudent.enrollCourse(course);
        }
        newStudent.printStudentInfo();
    }

    public static void findStudentById(){
        Student studentFound = null;
        System.out.println("Enter Student ID");
        String studentId = scanner.next();
        try {
            studentFound = studentList
                    .stream()
                    .filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No data Found"));
            studentFound.printStudentInfo();
        }catch (RuntimeException e){
        System.err.println("Student with ID " + studentId + " not found");
        }
    }

    private static void sortByName(){
        //code written in lambda expression its same as  code written in after 6 lines
        //Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
       if(!studentList.isEmpty()) {
            Comparator<Student> studentNameComparator = new Comparator<Student>() {
                @Override // auto generated method
                public int compare(Student o1, Student o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            };
            Collections.sort(studentList, studentNameComparator);
            //studentList.sort(studentNameComparator);
            //System.out.println(studentList);
            printAllStudentData();
        }else {
           System.out.println("Student list is empty.... no student record found");
       }
    }
}
