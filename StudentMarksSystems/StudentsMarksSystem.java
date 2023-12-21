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
        editStudentMarks(studentsInformation);
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
    public static void editStudentMarks(ArrayList<String> studentsInformation){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which student do you want to edit his marks: ");
        int studentId = scanner.nextInt();
        if (studentId > studentsInformation.size()){
            System.out.println("The student ID is greater than the list and not in the list");
        }
        String studentData= studentsInformation.get(studentId);
        System.out.println(studentData);
        String formattedStudentData = studentData.replaceAll("[\\[\\]| ]+", "");

        String[] stringFormattedStudentData = formattedStudentData.split(",");
        int stringSize = stringFormattedStudentData.length;
        System.out.println(stringSize);
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

//        String stringFormattedStudentDatum="";
        for (int i = 0; i < stringFormattedStudentData.length ;i++) {
            System.out.print("Enter the updated Details: ");
            if (editStudentData == 1){
                String editStudent = scanner.nextLine();
                String studentName=stringFormattedStudentData[1];
                studentName=editStudent;
                stringFormattedStudentData[1] = studentName;
                break;
            }
            if (editStudentData == 2){
                String editStudentMarkEnglish = scanner.nextLine();
                String updatedStudentEnglishMark=stringFormattedStudentData[1];
                updatedStudentEnglishMark=editStudentMarkEnglish;
                stringFormattedStudentData[2] = String.valueOf(updatedStudentEnglishMark);
                updatedTotal = Integer.parseInt(stringFormattedStudentData[2]) + Integer.parseInt(stringFormattedStudentData[3])+Integer.parseInt(stringFormattedStudentData[4])+Integer.parseInt(stringFormattedStudentData[5]+stringFormattedStudentData[6]);

                break;

            }
            if (editStudentData == 3){
                String editStudentMarkEnglish = scanner.nextLine();
                String updatedStudentKiswahiliMark=stringFormattedStudentData[1];
                updatedStudentKiswahiliMark=editStudentMarkEnglish;
                stringFormattedStudentData[3] = String.valueOf(updatedStudentKiswahiliMark);
                updatedTotal = Integer.parseInt((stringFormattedStudentData[2]) + Integer.parseInt(stringFormattedStudentData[3])+Integer.parseInt(stringFormattedStudentData[4])+Integer.parseInt(stringFormattedStudentData[5])+Integer.parseInt(stringFormattedStudentData[6]));

                break;
            }
            if (editStudentData == 4){
                String editStudentMarkEnglish = scanner.nextLine();
                String updatedStudentMathMark=stringFormattedStudentData[1];
                updatedStudentMathMark=editStudentMarkEnglish;
                stringFormattedStudentData[4] = String.valueOf(updatedStudentMathMark);
                updatedTotal = Integer.parseInt(stringFormattedStudentData[2]) + Integer.parseInt(stringFormattedStudentData[3])+Integer.parseInt(stringFormattedStudentData[4])+Integer.parseInt(stringFormattedStudentData[5]+stringFormattedStudentData[6]);

            }
            if (editStudentData == 5){
                String editStudentMarkEnglish = scanner.nextLine();
                String updatedStudentScienceMark=stringFormattedStudentData[1];
                updatedStudentScienceMark=editStudentMarkEnglish;
                stringFormattedStudentData[5] = String.valueOf(updatedStudentScienceMark);
                updatedTotal = Integer.parseInt(stringFormattedStudentData[2]) + Integer.parseInt(stringFormattedStudentData[3])+Integer.parseInt(stringFormattedStudentData[4])+Integer.parseInt(stringFormattedStudentData[5]+stringFormattedStudentData[6]);

                break;

            }
            if (editStudentData == 6){
                String editStudentMarkEnglish = scanner.nextLine();
                String updatedStudentSStudiesMark=stringFormattedStudentData[1];
                updatedStudentSStudiesMark=editStudentMarkEnglish;
                stringFormattedStudentData[6] = String.valueOf(updatedStudentSStudiesMark);
                updatedTotal = Integer.parseInt(stringFormattedStudentData[2]) + Integer.parseInt(stringFormattedStudentData[3])+Integer.parseInt(stringFormattedStudentData[4])+Integer.parseInt(stringFormattedStudentData[5]+stringFormattedStudentData[6]);

                break;

            }
//            int updatedTotal;
            double updatedAverage;

        }
        System.out.println(Arrays.toString(stringFormattedStudentData));
        System.out.println(stringFormattedStudentData[7]);
        System.out.println("Updated Total : "+updatedTotal);



    }
}
