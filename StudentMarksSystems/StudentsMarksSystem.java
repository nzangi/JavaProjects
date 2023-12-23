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
        printStudentsInformation(studentsInformation);
        ArrayList<String> editedStudentsMarks = editStudentMarks(studentsInformation);
        printStudentsInformation(editedStudentsMarks);
    }
    public static void printStudentsInformation(ArrayList<String> studentsInformation){
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
//        String studentName= "";
        for (int i = 0; i< numberOfStudents;i++){
            System.out.print("Enter the student name "+(i+1)+": ");
            studentNamesArray[i] = scanner.nextLine();
        }

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

            studentSubjectsMarks.add("||        "+studentTotalMarks+"       ||");
            studentSubjectsMarks.add("       "+studentAverageMarks+"    ||");
            studentSubjectsMarks.add(studentPerformance(studentAverageMarks)+"       |");

            studentsInformation.add(""+studentSubjectsMarks);
        }
        return studentsInformation;
    }
    public static ArrayList<String> editStudentMarks(ArrayList<String> studentsInformation){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which student do you want to edit his marks: ");
        int studentId = scanner.nextInt();
        int studentDropedData = studentId;
        if (studentId > studentsInformation.size()){
            System.out.println("The student ID is greater than the list and not in the list");
        }
        String studentData= studentsInformation.get(studentId);
//        System.out.println(studentData);
        String formattedStudentData = studentData.replaceAll("[\\[\\]| ]+", "");

        String[] stringFormattedStudentData = formattedStudentData.split(",");
//        int stringSize = stringFormattedStudentData.length;
//        System.out.println(stringSize);
        for (int i = 0; i < stringFormattedStudentData.length ;i++){
            if(i==1){
                System.out.println("Student Name is: "+stringFormattedStudentData[i]);
            }
            else if(i==2){
                System.out.println("Student"+stringFormattedStudentData[1]+" scored: "+stringFormattedStudentData[i]+" at ENGLISH");
            }
            else if(i==3){
                System.out.println("Student"+stringFormattedStudentData[1]+" scored: "+stringFormattedStudentData[i]+" at KISWAHILI");
            }
            else if(i==4){
                System.out.println("Student"+stringFormattedStudentData[1]+" scored: "+stringFormattedStudentData[i]+" at MATHS");
            }

            else if(i==5){
                System.out.println("Student"+stringFormattedStudentData[1]+" scored: "+stringFormattedStudentData[i]+" at SCIENCE");
            }
            else if(i==6){
                System.out.println("Student"+stringFormattedStudentData[1]+" scored: "+stringFormattedStudentData[i]+" at S/ STUDIES");
            }
        }

        System.out.print("Enter the data which you need to edit (From StudentName to S/ STUDIES )1-6: ");
        int editStudentData = scanner.nextInt();
        scanner.nextLine();
        int updatedTotal = 0;
        double updatedAverage =0;


        if (editStudentData == 1){
                System.out.print("Enter the updated Details: ");
                String editStudent = scanner.nextLine();
                String studentName;
                studentName=editStudent;
                stringFormattedStudentData[1] = studentName;

        }
        else {
            for (int i = 3; i < stringFormattedStudentData.length ;i++) {
                if (editStudentData == i){
                    System.out.print("Enter the updated Details: ");
                    String editStudentMark = scanner.nextLine();
                    String updatedStudentMark;
                    updatedStudentMark=editStudentMark;
                    stringFormattedStudentData[i] = updatedStudentMark;
                    updatedTotal = Integer.parseInt(stringFormattedStudentData[2]) + Integer.parseInt(stringFormattedStudentData[3])+Integer.parseInt(stringFormattedStudentData[4])+Integer.parseInt(stringFormattedStudentData[5])+Integer.parseInt(stringFormattedStudentData[6]);
                    stringFormattedStudentData[7] = String.valueOf(updatedTotal);
                    updatedAverage = (double) updatedTotal / 5;

                    stringFormattedStudentData[8] = String.valueOf(updatedAverage);
                    stringFormattedStudentData[9] = studentPerformance(updatedAverage);
                    break;
                }
            }
        }
        studentsInformation.remove(studentDropedData);
        studentsInformation.add("|       "+stringFormattedStudentData[0]+" |   "+stringFormattedStudentData[1]+"    || "+stringFormattedStudentData[2] +"       || "+stringFormattedStudentData[3]+"       || "+stringFormattedStudentData[4]+"       || "+stringFormattedStudentData[5]+"       || "+stringFormattedStudentData[6]+"       ||         "+stringFormattedStudentData[7]+"      ||         "+stringFormattedStudentData[8]+"   || "+stringFormattedStudentData[9] +"       |");
        return studentsInformation;

    }

    private static String studentPerformance(double averageMark){
        String studentPerformance;
        if(averageMark >= 70) {
            studentPerformance ="Excellent";
        }
        else if (averageMark >= 60){
            studentPerformance ="Very Good";

        }
        else if (averageMark >= 50){
            studentPerformance ="Average  ";

        }
        else if (averageMark >= 40){
            studentPerformance ="Pass     ";

        }
        else {
            studentPerformance ="Fail     ";

        }
        return studentPerformance;
    }
}
