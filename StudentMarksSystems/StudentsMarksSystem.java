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
        ArrayList<String> studentsInformation = giveEachStudentMarks();
        System.out.println("|---------------------------------------------------------------------------------------------------------------|");
        System.out.println("|| ENGLISH  || KISWAHILI || MATHS  || SCIENCE || SOCIAL STUDIES || STUDENT TOTAL MARKS || STUDENT TOTAL MARKS  ||" );
        System.out.println("|---------------------------------------------------------------------------------------------------------------|");
        for (String studentInformation : studentsInformation) {
            String result = studentInformation.replaceAll("[\\[\\],]", "");
            System.out.println(result);
        }
        System.out.println("|---------------------------------------------------------------------------------------------------------------|");


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

        for (String studentName: studentNames){
            int studentTotalMarks = 0;
            double studentAverageMarks = 0;
            System.out.println("Enter marks for "+studentName);
            ArrayList<String> studentSubjectsMarks = new ArrayList<>();

            for (String studentSubject: studentSubjects){
                System.out.print("Enter marks for "+studentName+" for subject "+studentSubject+" :");
                int marks = scanner.nextInt();
                studentTotalMarks += marks;
                studentSubjectsMarks.add("|| "+ marks +"      ");

            }
            studentAverageMarks = (double) studentTotalMarks / studentSubjects.length;
            studentSubjectsMarks.add("||                   "+studentTotalMarks+"   ||");
            studentSubjectsMarks.add("           "+studentAverageMarks+"      ||");

            studentsInformation.add(""+studentSubjectsMarks);
        }

        return studentsInformation;
    }
}
