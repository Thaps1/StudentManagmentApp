package com.mycompany.studentmanagementapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class StudentTest {

    private StudentManagementApp app;
    private List<Student> students;

    @Before
    public void setUp() {
        students = new ArrayList<>();
        app = new StudentManagementApp();
    }

    @Test
    public void testSaveStudent() {
        // Arrange
        String studentId = "ST1044";
        String studentName = "Thapelo Khoza";
        int age = 21;
        String email = "St10442543@rcconnect.com";
        String course = "DIS1";

        // Act
        Student student = new Student(studentName, studentId, age, email, course);
        students.add(student);

        // Assert
        assertNotNull(student);
        assertEquals("ST1044", student.getId());
        assertEquals("Thapelo Khoza", student.getStudentName());
    }

    @Test
    public void testSearchStudent() {
        // Arrange
        String studentId = "ST1044";
        Student student = new Student("Thapelo Khoza", studentId, 20, "St10442543@rcconnect.com", "Business");
        students.add(student);

        // Act
        Student foundStudent = searchStudent(studentId);

        // Assert
        assertNotNull(foundStudent);
        assertEquals("Thapelo Khoza", foundStudent.getStudentName());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        // Act
        Student foundStudent = searchStudent("ST1044");

        // Assert
        assertNull(foundStudent);
    }

    @Test
    public void testDeleteStudent() {
        // Arrange
        String studentId = "ST1044";
        Student student = new Student("Thapelo Khoza", studentId, 21, "St10442543@rcconnect.com", "Dis1");
        students.add(student);

        // Act
        boolean deleted = deleteStudent(studentId);

        // Assert
        assertTrue(deleted);
        assertNull(searchStudent(studentId));
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Act
        boolean deleted = deleteStudent("S999");

        // Assert
        assertFalse(deleted);
    }

    // Helper method to simulate the search functionality
    private Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // simulate the delete functionality
    private boolean deleteStudent(String id) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            return true;
        }
        return false;
    }
}
