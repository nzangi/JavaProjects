package SupermarketReceipt;

import java.util.ArrayList;
import java.util.Scanner;

public class SupermarketReceipt {
    public static void main(String[] args){
        System.out.println("<=======Supermarket Receipt========>");
        System.out.println("""
                Choose the Item to but from Supermarket
                1. Sugar 1Kg @ (KSH) 200
                2. Rice 1Kg @ (KSH) 150
                3. Floor 1Kg @ (KSH) 250
                4. Unga 1Kg @ (KSH) 180
                5. Salt 1Kg @ (KSH) 50
                """);

        ArrayList <Integer> itemsTotals = new ArrayList<>();
        ArrayList <String> itemDetails = new ArrayList<>();
        itemsDetails(itemDetails,itemsTotals);
        double balance = calculateTotal(itemsTotals);
        System.out.println("<=======Supermarket Receipt Printing========>");
        printItemDetails(itemDetails);
        System.out.println("| Your Balance is (KSH):       " + balance+"       |");
        System.out.println("| Thanks for shopping with us!             |");
        System.out.println("|------------------------------------------|");

    }

    public static void itemsDetails(ArrayList<String> itemDetails,ArrayList <Integer> itemsTotals){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter the Item choice to buy (1-5): ");
            int itemChoice = scanner.nextInt();
            System.out.print("Enter the Item Quality to buy for Item "+itemChoice+": ");
            int itemQuantity = scanner.nextInt();
            int itemTotal;
            String itemName = "";

            if (itemChoice ==1){
                itemName = "Sugar";
                itemTotal = itemQuantity * 200;
            } else if (itemChoice ==2) {
                itemName = "Rice ";
                itemTotal = itemQuantity * 150;
            }else if (itemChoice ==3) {
                itemName = "Floor";
                itemTotal = itemQuantity * 250;
            }else if (itemChoice ==4) {
                itemName = "Unga ";
                itemTotal = itemQuantity * 180;
            }else {
                itemName = "Salt ";
                itemTotal = itemQuantity * 50;
            }
            itemsTotals.add(itemTotal);
            itemDetails.add("| "+itemQuantity+" Kg      || "+itemName+"      ||   "+ itemTotal+" KSH     |");


            System.out.print("Do you want to add more items: Press 1 to continue,2 to quit: ");
            int quitOrContinue = scanner.nextInt();
            if (quitOrContinue == 1){
                continue;
            }else {
                System.out.println("Next to payment!");
                break;
            }
        }

    }
    public static void printItemDetails(ArrayList<String> itemDetails){
        // Print the table header
        System.out.println("|------------------------------------------|");
        System.out.println("| Quantity  || Item Name   ||  Item Total  |");
        System.out.println("|------------------------------------------|");
        for(String item: itemDetails){
            System.out.println(item);
        }
        // Print the table footer
        System.out.println("|------------------------------------------|");

    }
    public static double calculateTotal(ArrayList <Integer> itemsTotals) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (Integer itemsTotal : itemsTotals) {
            sum += itemsTotal;
        }
        System.out.println("Your total sum is: " + sum);
        System.out.println();
        //Process payment
        double balance;
        while (true) {
            System.out.print("Enter the amount given by customer (KSH): ");
            double customerPayGiven = scanner.nextDouble();
            if ((customerPayGiven > sum) || (customerPayGiven == sum)) {
                balance = customerPayGiven - sum;
                break;
            } else {
                System.out.println("Kindly, you need to top more, your items total is (KSH): " + sum);
            }
        }
        return balance;
    }
}