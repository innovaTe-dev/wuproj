/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab03;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
/**
 *
 * @author Tbeur
 */
public class CourseTester {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner readerCourse = new Scanner(new File("course.txt"));
            Course c = new Course(readerCourse.nextLine());
            int count = 0;
            String[] prntArray = new String[c.getNumberOfStudents()];
            while (readerCourse.hasNext())
            {
                c.addStudent(readerCourse.nextLine());
            }
        
        System.out.println(c.getCourseName());
        System.out.println(Arrays.toString(c.getStudents()));
        System.out.println("amount of students: " + c.getNumberOfStudents());
        c.dropStudent("Bugs Bunny");
        System.out.println("amount of students: " + c.getNumberOfStudents());
        c.addStudent("Elmer Fudd");
        c.addStudent("Marvin the Martian");
        System.out.println(c.getCourseName());
        System.out.println(Arrays.toString(c.getStudents()));
    }
}
