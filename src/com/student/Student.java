package com.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private int age;
    private String studentId;
    private List<String> courses;

    public Student(String name, int age, String studentId){

        if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<String>();
        }
    }

    public void enrollCourse(String course){
        if(validateCourseName(course)) {
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println("Student is enrolled for course " + course + " successfully");
            } else {
                System.err.println("Student already enrolled for course " + course);
            }
        }
    }
    public void printStudentInfo(){
        System.out.println("Student name : " + name);
        System.out.println("Student Age : " + age);
        System.out.println("Student ID : " + studentId);
        System.out.println("Enrolled for course : " + courses);
    }

    //Validation Methods
    private boolean validateAge(int age){
        if(age>=19 && age<=35){
            return true;
        }else{
            System.out.println("Invalid age!! Student Age between 19 and 35");
            return false;
        }
    }

    private boolean validateName(String name){
        String nameReg = "^[a-zA-Z ]+$";
        if(name != null && name.matches(nameReg)){
            return true;
        }else{
            System.out.println("Invalid name!! Please enter Alphabets only");
            return false;
        }
    }

    private boolean validateStudentId(String studentId) {
        String studentIdReg = "S-[0-9]+$";
        if(studentId != null && studentId.matches(studentIdReg)){
            return true;
        }else{
            System.out.println("Invalid Student ID");
            return false;
        }
    }

    private boolean validateCourseName(String course){
        if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOps")){
            return true;
        }else {
            System.out.println("Invalid course name !! Please select course from the list [Java, DSA, DevOps]");
            return false;
        }
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + " Age=" + age + " studentId=" +studentId+ "]";
    }
}
