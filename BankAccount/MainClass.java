package BankAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        currentAccountData();
    }

    public static void accountData(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of Accounts to register: ");
        int numberOfAccounts = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Account> accounts = new ArrayList<>();
        for (int i = 0;i < numberOfAccounts;i++){
            System.out.println("Enter the Account for "+(i+1)+" : ");
            System.out.print("Enter Account Holder Number: ");
            String accountHolderNumber = scanner.nextLine();
            System.out.print("Enter Account Holder ID: ");
            String accountHolderId = scanner.nextLine();
            System.out.print("Enter Account Holder Email Address: ");
            String accountHolderEmailAddress = scanner.nextLine();
            System.out.print("Enter Account Holder Telephone Number: ");
            String accountHolderTelephoneNumber = scanner.nextLine();
            System.out.print("Enter Account Holder Account Balance: ");
            double accountBalance = scanner.nextDouble();
            scanner.nextLine();
            Account account = new Account(accountHolderNumber,accountHolderId,
                    accountHolderEmailAddress,accountHolderTelephoneNumber,accountBalance);
            accounts.add(account);
            account.setAccountHolderEmailAddress("NewSetEmail@GMAIL.COM");

        }

        System.out.println("Printing account Details");
        System.out.println("=======================================================");
        System.out.println();
        for (Account account: accounts){
            account.displayAccountDetails();
        }
        System.out.print("Enter the client account Number which to deposit Money to: ");
        String accountToDepositMoney = scanner.nextLine();
        for (Account account: accounts){
            if (accountToDepositMoney.equals(account.getAccountHolderNumber())){
                System.out.print("Enter the amount to deposit: ");
                double amountToDeposit = scanner.nextDouble();
                account.deposit(amountToDeposit);
                System.out.println("Deposit of "+amountToDeposit+" was successful");
                System.out.println("Your current balance is KSH: "+account.getAccountBalance());
                System.out.println();
                account.displayAccountDetails();
                break;
            }
        }

    }
    public static void currentAccountData(){
        CurrentAccount currentAccount = new CurrentAccount("1","1",300);
        System.out.println(currentAccount.getCurrentAccountBalance());
    }
}
