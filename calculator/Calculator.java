package calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String [] args){
        doCalculation();
    }

//    The method does calculation after getting number and number two
    public static void doCalculation(){
        int numberOne = getInputNumberOne();
        int numberTwo = getInputNumberTwo();
        String operand="";
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Enter the operation do do with the two numbers: ");
                operand = scanner.next();
                String[] operands = {"/", "*", "%", "+", "-"};
                for (String stringOperand : operands) {
                    if (operand.equals(stringOperand)) {
                        System.out.println("Your operand is:" + operand);
//                        the switchPrint method arguments are given here
                        switchPrint(numberOne,numberTwo,operand);
                        System.out.println();
                        System.out.println("The Project is Over!");
                        return;
                    }
                }
                System.out.println("Enter a valid operand: ");
                scanner.nextLine();
            }
            catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                scanner.nextLine();
            }
        }

    }
//    The method gets the first number
    public static int getInputNumberOne(){
        int numberOne;
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Enter the value of number One: ");
                numberOne = scanner.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Enter integers only!");
                scanner.nextLine();
            }
        }
        return  numberOne;
    }

    //    The method gets the second number

    public static int getInputNumberTwo(){
        int numberTwo;
        Scanner scanner = new Scanner(System.in);

        while (true){
            try {
                System.out.print("Enter the value of number Two: ");
                numberTwo = scanner.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Enter integers only!");
                scanner.nextLine();
            }
        }
        return numberTwo;

    }

    //    The method is work is to do the actual calculation by calling the parameters function such as addition etc

    public static void switchPrint(int numberOne,int numberTwo,String operand){
        switch (operand){
            case "+":
                System.out.print("The sum of "+numberOne+" and "+ numberTwo+" is : "+addition(numberOne,numberTwo));
                break;
            case "-":
                System.out.print("The subtraction of "+numberOne+" and "+ numberTwo+" is : "+subtraction(numberOne,numberTwo));
                break;
            case "/":
                System.out.print("The division of "+numberOne+" and "+ numberTwo+" is : "+division(numberOne,numberTwo));
                break;
            case "%":
                System.out.print("The modulas of "+numberOne+" and "+ numberTwo+" is : "+modulas(numberOne,numberTwo));
                break;
            case "*":
                System.out.print("The multiplication of "+numberOne+" and "+ numberTwo+" is : "+multiplication(numberOne,numberTwo));
                break;
        }
    }
//The sum methods, it takes two parameters
    public static int addition(int numberOne,int numberTwo){
        int sum=numberOne +numberTwo;
        return sum;
    }
    //The multiplication method, it takes two parameters

    public static int multiplication(int numberOne,int numberTwo){
        int product=numberOne * numberTwo;
        return product;
    }
    //The subtraction method, it takes two parameters

    public static int subtraction(int numberOne,int numberTwo){
        int subtraction=numberOne - numberTwo;
        return subtraction;
    }

    //The division method, it takes two parameters

    public static int division(int numberOne,int numberTwo){
        int division=numberOne / numberTwo;
        return division;
    }
    //The modules method, it takes two parameters

    public static int modulas(int numberOne,int numberTwo){
        int modula=numberOne % numberTwo;
        return modula;
    }
}