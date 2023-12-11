package Quiz_Game;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args){
        checkAnswerIsCorrect();
//        main method
    }
//    Ask questions
    public static String[] askQuestions(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Q1: What is the capital city of Kenya: ");
        String answerQuestionOne = scanner.nextLine();
        System.out.print("Q2: What is the capital city of Uganda: ");
        String answerQuestionTwo = scanner.nextLine();
        System.out.print("Q3: What is the capital city of Tanzania: ");
        String answerQuestionThree = scanner.nextLine();

        String [] answersToQuestions = new String[]{answerQuestionOne,answerQuestionTwo,answerQuestionThree};

        return answersToQuestions;
    }
//    Check if answer is correct
    public static void checkAnswerIsCorrect(){
        String [] answers = new  String[]{"Nairobi", "Kampala", "Dodoma"};
        int points;
        int sumPoints=0;
        String[] userAnswers = askQuestions();
        if (Objects.equals(userAnswers[0], answers[0])){
            System.out.println("You are correct");
            points=3;
            sumPoints +=points;
            System.out.println("You have been awarded 3 points");

        }
        if (Objects.equals(userAnswers[1], answers[1])){
            System.out.println("You are correct");
            points=3;
            sumPoints +=points;
            System.out.println("You have been awarded 3 points");
        }
        if (Objects.equals(userAnswers[2], answers[2])){
            System.out.println("You are correct");
            points=3;
            sumPoints +=points;
            System.out.println("You have been awarded 3 points");
        }
        System.out.println("Your total Points are: "+sumPoints);


    }
//    award points
    public static void awardMarks(){

    }
}
