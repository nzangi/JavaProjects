package StudentMarksSystems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//main method
//enter the student index and marks
//calculate the average
//Give excellent, good, fair fail according to student average
//give class average
public class StudentsMarksSystem {
    public static void main(String[] args){
        giveEachStudentMarks();

    }
    public static String[] studentsNames(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of your students: ");
        int numberOfStudents = scanner.nextInt();
        // Consume the newline character
        scanner.nextLine();
        String[] studentNamesArray = new String[numberOfStudents];
        String studentName= "";
        for (int i = 0; i< numberOfStudents;i++){
            System.out.print("Enter the student name "+(i+1)+": ");
            studentNamesArray[i] = scanner.nextLine();
        }
//        System.out.println(Arrays.toString(studentNamesArray));
        return studentNamesArray;
    }
    public static String [] studentSubjects(){
        String [] studentSubjects = {"ENGLISH","KISWAHILI","MATHS","SCIENCE","SOCIAL STUDIES"};
        return studentSubjects;
    }
    public static void giveEachStudentMarks(){
        Scanner scanner = new Scanner(System.in);

        String[] studentNames = studentsNames();
        String[] studentSubjects = studentSubjects();
//        ArrayList<String> studentsInformation = new ArrayList<>();

        for (String studentName: studentNames){
            int studentTotalMarks = 0;
            double studentAverageMarks = 0;
            System.out.println("Enter marks for "+studentName);
            for (String studentSubject: studentSubjects){
                System.out.print("Enter marks for "+studentName+"for subject "+studentSubject+" :");
                int marks = scanner.nextInt();
                studentTotalMarks += marks;
            }
            studentAverageMarks = (double) studentTotalMarks / studentSubjects.length;

            System.out.println(studentName+" total marks is "+studentTotalMarks+" and your average is "+studentAverageMarks);
        }
    }
}
