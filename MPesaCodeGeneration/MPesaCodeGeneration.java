package MPesaCodeGeneration;

import java.text.SimpleDateFormat;
import java.util.*;


public class MPesaCodeGeneration {
    private static int transcationCount = -1;  // Initialize at -1 to start from 0 in the first transaction
    public static void main(String[] args){
        System.out.println("You are now starting your trancation : ");
        generateMpesaCode();
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Do you want to do another transaction:\n" +
                    "PRESS 1 for another function or 1 to cancel: ");
            int choice  = scanner.nextInt();
            if (choice==1){
                generateMpesaCode();
            }
            else {
                System.out.println("You have successfully excited from the program!");
                break;
            }
        }
        while (true);


    }
//    the method calculates if a year is leap or not
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
//    The function if the value of date and month entered by user exists
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
// This is the method which prints all information about the transaction
    private static void generateMpesaCode(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy hh:mm:ss a");
        int [] dataForYear = checkMonth();
        int firstYearForCodeGeneration = 2005;
        String mpesaCode = "";
        if(dataForYear[0] < firstYearForCodeGeneration){
            System.out.println("By this year, the system was not working. enter a value after 2006");
        }
        int getYearDifference = dataForYear[0] - firstYearForCodeGeneration;
        if (getYearDifference > 26){
            getYearDifference = getYearDifference % 26;
        }
        HashMap<Integer, String> mpesaCodes = getYearMpesaCodesHashMap();
        HashMap<Integer, String> mpesaMonthCodes = getMonthMpesaCodesHashMap();
        String mpesaYearCode = mpesaCodes.get(getYearDifference);
        String mpesaMonthCode= mpesaMonthCodes.get(dataForYear[1]);

        mpesaCode = mpesaYearCode+mpesaMonthCode+dataForYear[2]+getLast8MpesaCodes();
        int [] sendMoneyDetails = getAmountTransferredAndReceived();
        String senderName = "DYMPHINA  ONGWAE";
        String senderNumber = "+254711111111";
        String reciverName = "JOHN MUOKI";
        String receiverNumber = "0722222222";
        System.out.println("Sender Message");
        System.out.println("=================");

        System.out.println(mpesaCode+" Confirmed. "+sendMoneyDetails[1]+" sent to "+reciverName+" "+receiverNumber+" on "+formatter.format(date)+". New M-PESA balance is "+sendMoneyDetails[0]+"\n" +
                "Transaction cost, Ksh7.00. Amount you can transact within the day is 487,590.00. To reverse, foward this message to 456 ");

        System.out.println("Receiver Message");
        System.out.println("=================");

        System.out.println(mpesaCode+" Confirmed.You have received Ksh"+sendMoneyDetails[1]+ " from "+senderName+" "+senderNumber+" on "+formatter.format(date)+"  New M-PESA balance is Ksh"+sendMoneyDetails[2]+". Register for lipa \n" +
                "na M-PESA till for free today. Click https://m-pesaforbusiness.co.ke/LNM/ ");

    }

//    The method gives details about the trancation, it also checks if the sender ahs enough funds to carry out the transaction
    private static int[] getAmountTransferredAndReceived(){
        Scanner scanner = new Scanner(System.in);
        int amountToSend,senderBalance,balanceAfterSend,receiverAmount,receiverBalance;
        System.out.print("Enter the sender current account balance (KSH): ");
        senderBalance = scanner.nextInt();
        System.out.print("Enter the amount to send (KSH): ");
        amountToSend = scanner.nextInt();
        System.out.print("Enter the receiver current account balance (KSH): ");
        receiverBalance = scanner.nextInt();
        int[] sendMoneyDetails =new int[4];

        if (senderBalance > amountToSend){
            balanceAfterSend = senderBalance-amountToSend;
            receiverAmount = amountToSend + receiverBalance;
            sendMoneyDetails = new int[]{balanceAfterSend, amountToSend,receiverAmount,receiverBalance};


        }
        else {
            System.out.println("You don't have funds to transfer "+amountToSend+". Your balance is "+senderBalance+" .");
        }
        return sendMoneyDetails;
    }
//this method show the last digits in a sequential way in each trancation;
    private static String getLast8MpesaCodes(){
        HashMap<Integer,String> mpesaCodes = new HashMap<>();
        for (int i =1;i<=26;i++){
            mpesaCodes.put(i,String.valueOf((char) (i+64)));
        }
        transcationCount++;
        String[] stringMpesaCodes = new String[8];
        for (int i =0; i < 8;i++){
            stringMpesaCodes[i] = mpesaCodes.get((transcationCount+i) % 26 + 1);
        }
        String mpesaCode = String.join("",stringMpesaCodes);
        return mpesaCode;

    }
//the method returns each year with is own Code for year from remember key 1==2005 when mpesa started
    private static HashMap<Integer, String> getYearMpesaCodesHashMap() {
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
        return mpesaCodes;
    }
//the method returns each month with is own Code for moth january A== December L

    private static HashMap<Integer, String> getMonthMpesaCodesHashMap() {
        HashMap<Integer,String> mpesaMonthCodes = new HashMap<>();
        mpesaMonthCodes.put(1,"A");
        mpesaMonthCodes.put(2,"B");
        mpesaMonthCodes.put(3,"C");
        mpesaMonthCodes.put(4,"D");
        mpesaMonthCodes.put(5,"E");
        mpesaMonthCodes.put(6,"F");
        mpesaMonthCodes.put(7,"G");
        mpesaMonthCodes.put(8,"H");
        mpesaMonthCodes.put(9,"I");
        mpesaMonthCodes.put(10,"J");
        mpesaMonthCodes.put(11,"K");
        mpesaMonthCodes.put(12,"L");
        return mpesaMonthCodes;
    }
//the method returns days of each moth and cjecks if a year is leap or not. for leap, the days re 29
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
