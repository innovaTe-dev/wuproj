/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab03;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Tbeur
 */
public class Course {
    private String courseName = "";
    ArrayList<String> students = new ArrayList<>();
    private int numberOfStudents = 0;
    public Course(String courseName)
    {
        this.courseName = courseName;
    }
    public void addStudent(String student)
    {
        students.add(student);
        numberOfStudents++;
    }
    public String[] getStudents()
    {
        String[] studentsConv = new String[numberOfStudents];
        studentsConv = students.toArray(studentsConv);
        return studentsConv;
    }
    public int getNumberOfStudents()
    {
        return numberOfStudents;
    }
    public String getCourseName()
    {
        return courseName;
    }
    public void dropStudent(String student)
    {
        students.remove(student);
        numberOfStudents--;
    }
}
