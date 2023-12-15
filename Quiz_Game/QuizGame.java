package Quiz_Game;

import java.util.Objects;
import java.util.Scanner;

public class QuizGame {
    //  Main method
    public static void main(String[] args){
        yourScore();
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

        for (int i = 0; i< askQuestions().length;i++){
            for (int j = 0;j<3;j++){
                System.out.print(askQuestions()[i]);
                questionAnswer= scanner.nextLine();
                if (Objects.equals(questionAnswer.toUpperCase(), questionAnswers[i].toUpperCase())) {
                    if (j == 0) {
                        maximumPoints = 3;
                    } else if (j == 1) {
                        maximumPoints = 2;
                    } else {
                        maximumPoints = 1;
                    }
                    sumPoints += maximumPoints;
                    break;
                }
             }
        }
        return sumPoints;
    }
    //    calculating your score
    public static void yourScore(){
        int sumPoints=checkAnswerIsCorrect();
        System.out.println(sumPoints);
        int totalPoints=9;
        double percentageScore;
        percentageScore = ((double) sumPoints / totalPoints)*100;

        System.out.println("Your Total points is: "+sumPoints+" out of total 9 points");
        System.out.print("Your percentage score is : ");
        System.out.printf("%,.2f",percentageScore);
        System.out.print(" %");
    }
}
