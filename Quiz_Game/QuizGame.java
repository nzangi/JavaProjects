package Quiz_Game;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args){
        awardMarks();
//        main method
    }
//    Ask questions
    public static String[] askQuestions(){

        String []  askQuestions= new String[]{
                "Q1: What is the capital city of Kenya: ",
                "Q2: What is the capital city of Uganda: ",
                "Q3: What is the capital city of Tanzania:"
        };

        return askQuestions;
    }
//    Check if answer is correct
    public static int checkAnswerIsCorrect() {
        Scanner scanner = new Scanner(System.in);
        String [] questionAnswers = new  String[]{"Nairobi", "Kampala", "Dodoma"};
        String questionAnswer = "";
        int maximumPoints;
        int sumPoints =0;
        for (String question : askQuestions()) {
            for (int i = 0;i<3;i++){
                System.out.print(question);
                questionAnswer = scanner.nextLine();
                if(Objects.equals(questionAnswer.toUpperCase(), questionAnswers[0].toUpperCase())){
                    if(i==0){
                        maximumPoints=3;
                    } else if (i==1) {
                        maximumPoints=2;
                    } else {
                        maximumPoints=1;
                    }
                    sumPoints +=maximumPoints;
                    break;
                }
                if(Objects.equals(questionAnswer.toUpperCase(), questionAnswers[1].toUpperCase())){
                    if(i==0){
                        maximumPoints=3;
                    } else if (i==1) {
                        maximumPoints=2;
                    } else {
                        maximumPoints=1;
                    }
                    sumPoints +=maximumPoints;
                    break;
                }
                if(Objects.equals(questionAnswer.toUpperCase(), questionAnswers[2].toUpperCase())){
                    if(i==0){
                        maximumPoints=3;
                    } else if (i==1) {
                        maximumPoints=2;
                    } else {
                        maximumPoints=1;
                    }
                    sumPoints +=maximumPoints;
                    break;
                }

            }
        }
//        System.out.println(sumPoints);
        return sumPoints;
    }
    public static void awardMarks(){
        int sumPoints=checkAnswerIsCorrect();
        System.out.println(sumPoints);
        int totalPoints=9;
        double percentageScore;
        percentageScore = ((double) sumPoints / totalPoints)*100;

        System.out.println("Your Total points is: "+sumPoints);
        System.out.print("Your percentage score is : "+percentageScore);


    }
}
