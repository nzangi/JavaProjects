package calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int numberOne,numberTwo;
        String operand="";
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

        while (true){
                try {
                    System.out.print("Enter the operation do do with the two numbers: ");
                    operand = scanner.next();
                    String[] operands = {"/", "*", "%", "+", "-"};
                    for (String stringOperand : operands) {
                        if (operand.equals(stringOperand)) {
                            System.out.println("Your operand is:" + operand);
                        }
                    }
                    break;
                }
                catch (Exception e) {
                    System.out.print("Enter a valid operand: ");
                    scanner.nextLine();
                }
        }
        switchPrint(numberOne,numberTwo,operand);



//        scanner.close();


    }
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
//            default:
//                System.out.println("No such Operand. Try again");

        }
    }

    public static int addition(int numberOne,int numberTwo){
        int sum=numberOne +numberTwo;
        return sum;
    }
    public static int multiplication(int numberOne,int numberTwo){
        int product=numberOne * numberTwo;
        return product;
    }
    public static int subtraction(int numberOne,int numberTwo){
        int subtraction=numberOne - numberTwo;
        return subtraction;
    }
    public static int division(int numberOne,int numberTwo){
        int division=numberOne / numberTwo;
        return division;
    }
    public static int modulas(int numberOne,int numberTwo){
        int modula=numberOne % numberTwo;
        return modula;
    }
}