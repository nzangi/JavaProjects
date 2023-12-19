package StudentMarksSystems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//main method
//enter the student name
// Enter each student marks for 5 subjects
//calculate the average
//Give excellent, good, fair fail according to student average
//give class average
public class StudentsMarksSystem {
    public static void main(String[] args){
        ArrayList<String> studentsInformation = giveEachStudentMarks();
        System.out.println("|---------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| STDID || STD NAME || ENGLISH  || KISWAHILI || MATHS  || SCIENCE || S/ STUDIES || STD TOTAL MARKS || STD AVG MARKS  || STD PERFORMANCE | " );
        System.out.println("|---------------------------------------------------------------------------------------------------------------------------------------|");
        for (String studentInformation : studentsInformation) {
            String result = studentInformation.replaceAll("[\\[\\],]", "");
            System.out.println(result);
        }
        System.out.println("|---------------------------------------------------------------------------------------------------------------------------------------|");

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
    public static ArrayList<String> giveEachStudentMarks(){
        Scanner scanner = new Scanner(System.in);

        String[] studentNames = studentsNames();
        String[] studentSubjects = studentSubjects();
        ArrayList<String> studentsInformation = new ArrayList<>();
        ArrayList<String> studentsIds = new ArrayList<>();
        int studentIDCounter = 1;

        for (String studentName: studentNames){
            int studentTotalMarks = 0;
            int studentID =studentIDCounter++ ;
            double studentAverageMarks;
            System.out.println("Enter marks for "+studentName);
            ArrayList<String> studentSubjectsMarks = new ArrayList<>();
            studentsIds.add(String.valueOf(studentID));
            studentSubjectsMarks.add("|       "+studentID);
            studentSubjectsMarks.add("|   "+studentName+"   ");
            for (String studentSubject: studentSubjects){
                System.out.print("Enter marks for "+studentName+" for subject "+studentSubject+" :");
                int marks = scanner.nextInt();
                studentTotalMarks += marks;
                studentSubjectsMarks.add("|| "+ marks +"      ");

            }
            studentAverageMarks = (double) studentTotalMarks / studentSubjects.length;
            String studentPerformance = "";
            if(studentAverageMarks >= 70) {
                studentPerformance ="Excellent";
            }
            else if (studentAverageMarks >= 60){
                studentPerformance ="Very Good";

            }
            else if (studentAverageMarks >= 50){
                studentPerformance ="Average  ";

            }
            else if (studentAverageMarks >= 40){
                studentPerformance ="Pass     ";

            }
            else {
                studentPerformance ="Fail     ";

            }
            studentSubjectsMarks.add("||        "+studentTotalMarks+"       ||");
            studentSubjectsMarks.add("       "+studentAverageMarks+"    ||");
            studentSubjectsMarks.add(studentPerformance+"       |");

            studentsInformation.add(""+studentSubjectsMarks);
        }

        return studentsInformation;
    }
    public static void editStudentMarks(){

    }
}
