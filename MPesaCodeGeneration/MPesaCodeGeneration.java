package MPesaCodeGeneration;

import java.util.HashMap;
import java.util.Scanner;

/*
SA30ZVUWF2 Confirmed.You have received Ksh1.64
from M-PESA GlobalPay 903470 on 3/1/24 at 9:04 PM
 */
public class MPesaCodeGeneration {
    public static void main(String[] args){
        checkMonth();

    }
    public static int leapYear(int year){
        if ((year % 4)==0){
            if(((year % 100)==0)){
                if(((year % 400)==0)){
                    System.out.println(year+" it is lear year");
                    return 1;
                }
                else {
                    System.out.println(year + " it is not a leap year");
                    return 0;

                }
            }
            else{
                System.out.println(year+" it is a leap year");
                return 1;

            }
        }else{
            System.out.println(year+" it is not a leap year");
            return 0;

        }

    }
    public static void checkMonth(){
        Scanner scanner  = new Scanner(System.in);
        System.out.print("Enter the to check if it is leap: ");
        int year = scanner.nextInt();
        System.out.print("Enter the month of year "+year+"(1-12) : ");
        int month = scanner.nextInt();
        int returnLeapYear = leapYear(year);
        HashMap<Integer, Integer> monthDays = new HashMap<>();
        if (returnLeapYear == 1){
            monthDays.put(1, 31);
            monthDays.put(2, 29);
            monthDays.put(3, 31);
            monthDays.put(4, 30);
            monthDays.put(5, 31);
            monthDays.put(6, 30);
            monthDays.put(7, 31);
            monthDays.put(8, 31);
            monthDays.put(9, 30);
            monthDays.put(10, 31);
            monthDays.put(11, 30);
            monthDays.put(12, 31);
        }else {
            monthDays.put(1, 31);
            monthDays.put(2, 28);
            monthDays.put(3, 31);
            monthDays.put(4, 30);
            monthDays.put(5, 31);
            monthDays.put(6, 30);
            monthDays.put(7, 31);
            monthDays.put(8, 31);
            monthDays.put(9, 30);
            monthDays.put(10, 31);
            monthDays.put(11, 30);
            monthDays.put(12, 31);
        }

        System.out.println("The month "+month+" has "+monthDays.get(month)+" days");


    }
}
