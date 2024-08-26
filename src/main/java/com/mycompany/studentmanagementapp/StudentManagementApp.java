
package com.mycompany.studentmanagementapp;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class StudentManagementApp {
    
private static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        
        // Display the initial message when the application starts
        String welcomeMessage=JOptionPane.showInputDialog("Student Management Application\n"
                + "Enter 1 to open the menu.");
        if (!"1".equals(welcomeMessage)) {
            JOptionPane.showMessageDialog(null, "Exiting application. Goodbye!");
            System.exit(0); // Exit the application if the number is not 1
        
        }
            
        //Menu Have all the options of the student application.
        while(true){
        String menu=JOptionPane.showInputDialog( "1. Capture a new student.\n"
                + "2. Search for a student.\n"
                + "3. Delete a student.\n"
                + "4. Print student report.\n"
                + "5. Exit Application\n");
        
        switch (menu){
        
            case "1":
             SaveStudent();   
             break;
             
             case "2":
              SearchStudent();  
             break;   
             case "3":
              DeleteStudent();  
             break;   
             case "4":
              StudentReport();  
             break;   
             case "5":
              ExitStudentApplication() ; 
             break;   
        default:
            JOptionPane.showMessageDialog(null, "Invalid option! Please try again.");
        }
        
        }
        
    }
    private static void SaveStudent(){
        //Where the student details are captured
    String studentId = JOptionPane.showInputDialog("Enter the student id");
     int age = -1; // Initialize age with an invalid value
    String ageInput; // To store user input

    // Prompt until a valid age is entered
    while (true) {
        ageInput = JOptionPane.showInputDialog("Enter the student age.:");

        // Check if the input is a valid number
        if (ageInput != null && ageInput.matches("\\d+")) {
            age = Integer.parseInt(ageInput); 
            if (age >= 16) {
                break; // Exit the loop if the age is valid
            } else {
                JOptionPane.showMessageDialog(null, "You have entered the incorrect age."
                        + "Please re-enter age.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for age.");
        }
    }
        String studentName = JOptionPane.showInputDialog("Enter student name");
        String email = JOptionPane.showInputDialog("Enter the student email");
        String course = JOptionPane.showInputDialog("Enter the student course");
        
       
        
        Student student = new Student(studentName, studentId, age, email, course);
        students.add(student);
        JOptionPane.showMessageDialog(null, "Student details captured successfully");
      
    }
    private static void SearchStudent(){
    //prompt user to enter the student id to search
     String id=JOptionPane.showInputDialog("Enter the student id to search");
     Student foundStudent = null;
     
     for(Student student:students){
     if(student.getId().equals(id)){
      foundStudent = student;
            break;
     }
     
     if(foundStudent!=null){
     JOptionPane.showMessageDialog(null,"Student Found;"+student);
     }else{
     JOptionPane.showMessageDialog(null, "Student not found");
     
     }
     }
        
    }
    private static void DeleteStudent(){
     //prompt user on which student to delete
     String id = JOptionPane.showInputDialog("Enter Student ID to delete:");
    Student studentToRemove = null;

    // Loop through the list of students to find the one to delete
    for (Student student : students) {
        if (student.getId().equals(id)) {
            studentToRemove = student;
            break;  
        }
    }

    // Confirmation to delete
    if (studentToRemove != null) {
        int confirmation = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete this student?\n" + studentToRemove,
                "Delete Confirmation", JOptionPane.YES_NO_OPTION);  // Correctly uses YES_NO_OPTION

        if (confirmation == JOptionPane.YES_OPTION) {
            students.remove(studentToRemove);
            JOptionPane.showMessageDialog(null, "Student deleted successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Deletion canceled");
        }
    } else {
        // displayed if no student was found 
        JOptionPane.showMessageDialog(null, "Student not found");
    }
}
    private static void StudentReport(){
    
     //if no student report is capture this is the message that will be displayed
      if(students.isEmpty()){
        JOptionPane.showMessageDialog(null, "No students to display.");
        return; // Return is used to the method early.
     
     }  
     
     StringBuilder report= new StringBuilder();
     //initalize counter so we can have number of student
     int counter=1;
     for (Student student : students) {
         report.append("Student ").append(counter).append(":\n")
            .append(student.toString()).append("\n").
             append("-------------------------------------------------\n");counter++;
        }
        JOptionPane.showMessageDialog(null, report.toString());
     
     
    }
    private static void ExitStudentApplication(){
        //message displayed when exit application is selected
    JOptionPane.showMessageDialog(null,"Goodbye");
    System.exit(0);
    }
    
    
}
