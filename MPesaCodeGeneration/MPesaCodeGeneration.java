package MPesaCodeGeneration;

import java.util.Arrays;
import java.util.Formattable;
import java.util.HashMap;
import java.util.Scanner;

/*
SA30ZVUWF2 Confirmed.You have received Ksh1.64
from M-PESA GlobalPay 903470 on 3/1/24 at 9:04 PM
 */
public class MPesaCodeGeneration {
    public static void main(String[] args){
        generateMpesaCode();

    }
    private static int leapYear(int year){
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
    private static int[] checkMonth(){
        Scanner scanner  = new Scanner(System.in);
        System.out.print("Enter the to check if it is leap: ");
        int year = scanner.nextInt();
        System.out.print("Enter the month of year "+year+"(1-12) : ");
        int month = scanner.nextInt();
        int returnLeapYear = leapYear(year);
        HashMap<Integer, Integer> monthDays = getDaysOfMonthHashMap(returnLeapYear);

        System.out.println("The month "+month+" has "+monthDays.get(month)+" days");
        System.out.print("Enter the day of the month "+month+" : ");
        int date = scanner.nextInt();
        if(date >monthDays.get(month)){
            System.out.println("Invalid date of "+date+" in the month of "+month);
        }
        else if (date <= 0){
            System.out.println("Date cannot be less than 1");
        }
        else {
            System.out.println("Valid date of "+date+" in the month of "+month);
        }

        int [] dataForYear = {year,month,date};
        return dataForYear;

    }
    private static void generateMpesaCode(){
        int [] dataForYear = checkMonth();
        System.out.println(Arrays.toString(dataForYear));
        int firstYearForCodeGeneration = 2006;
        String mpesaCode = "";
        if(dataForYear[0] < firstYearForCodeGeneration){
            System.out.println("By this year, the system was not working. enter a value after 2006");
        }

        HashMap<Integer,String> mpesaCodes = new HashMap<>();
        mpesaCodes.put(1,"A");
        mpesaCodes.put(2,"B");
        mpesaCodes.put(3,"C");
        mpesaCodes.put(4,"D");
        mpesaCodes.put(5,"E");
        mpesaCodes.put(6,"F");
        mpesaCodes.put(7,"G");
        mpesaCodes.put(8,"H");
        mpesaCodes.put(9,"I");
        mpesaCodes.put(10,"J");
        mpesaCodes.put(11,"K");
        mpesaCodes.put(12,"L");
        mpesaCodes.put(13,"M");
        mpesaCodes.put(14,"N");
        mpesaCodes.put(15,"O");
        mpesaCodes.put(16,"P");
        mpesaCodes.put(17,"Q");
        mpesaCodes.put(18,"R");
        mpesaCodes.put(19,"S");
        mpesaCodes.put(20,"T");
        mpesaCodes.put(21,"U");
        mpesaCodes.put(22,"V");
        mpesaCodes.put(23,"W");
        mpesaCodes.put(24,"X");
        mpesaCodes.put(25,"Y");
        mpesaCodes.put(26,"Z");
        String firstMpesaCode = mpesaCodes.get(1);
        if (dataForYear[0]== firstYearForCodeGeneration){
            mpesaCode = firstMpesaCode;
            System.out.println(mpesaCode);
        }
//        for (int i =1;i<27;i++){
//            mpesaCode = mpesaCodes.get()
//        }

    }
    private static HashMap<Integer,Integer> getDaysOfMonthHashMap(int returnLeapYear){
        HashMap <Integer,Integer> monthDays = new HashMap<>();
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

        return monthDays;
    }

}
