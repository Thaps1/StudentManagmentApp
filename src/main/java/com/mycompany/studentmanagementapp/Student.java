package com.mycompany.studentmanagementapp;


public class Student {
  
   private String studentName;
   private String id;
   private int age;
   private String email;
   private  String course;

public Student(String studentName,String id,int age, String email,String course){
    //setters
   this.studentName=studentName;
   this.id=id;
   this.age=age;
   this.email=email;
   this.course=course;
}
   //all getters
    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }
 
@Override
    public String toString() {
      return "Student ID: " + id + "\n" +
           "Student Name: " + studentName + "\n" +
           "Student Age: " + age + "\n" +
           "Student Email: " + email + "\n" +
           "Student Course: " + course;

    }
    
}
