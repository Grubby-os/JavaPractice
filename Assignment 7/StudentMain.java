/* This program asks the user for the number of students, then for each student's name and the grade
   points of each of that student's courses. It stores the Student objects in an array and finishes
   by printing every student's name and GPA. This program utilizes the for-each loop from last chapter,
   to look through every object in the array to print it out. */

import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        giveIntro();

        System.out.print("How many students?: ");
        int numStudents = console.nextInt();

        Student[] students = new Student[numStudents];
        for(int i = 0; i < students.length; i++) {
            students[i] = readStudent(console);
        }

        printReport(students);

        console.close();
    }

    public static void giveIntro() {
        System.out.println("This program computes the GPA of each student");
        System.out.println("Enter each student's name (one word), then the grade points of each course");
        System.out.println("(4.0 = A, 3.0 = B, 2.0 = C, 1.0 = D, 0.0 = F).");
        System.out.println();
    }

    public static Student readStudent(Scanner console) {
        System.out.print("What is the student's name?: ");
        String name = console.next();

        Student student = new Student(name);

        System.out.print("How many courses?: ");
        int numCourses =  console.nextInt();

        for(int i = 1; i <= numCourses; i++) {
            System.out.print("Course " + i + " points: ");
            double gradePoints = console.nextDouble();
            student.addCourse(gradePoints);
        }
        System.out.println();
        return student;
    }

    public static void printReport(Student[] students) {
        System.out.printf("%-12s %s%n", "Name", "GPA");
        System.out.println("-----------------");

        for(Student student : students) {
            System.out.printf("%-12s %.2f%n", student.getName(), student.getGPA());
        }
    }
}