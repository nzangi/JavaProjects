package BankAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter the type of account you want to create.\nPress 1 for " +
                    "Current Account, press 2 for Saving Account: ");
            int accountType = scanner.nextInt();
            if (accountType == 1){
                getCurrentAccountsData();

            }else  if(accountType==2){
                getSavingsAccountsData();
            }else {
                System.out.println("Invalid Input");
            }
            System.out.print("Do you want to Quit The program.Press 1 to quit: ");
            int choice = scanner.nextInt();
            if(choice==1){
                break;
            }else if (choice ==2){
                continue;
            }else {
                System.out.println("Invalid Input");
            }
        }

    }
    public static void withdraw(ArrayList<CurrentAccount> currentAccounts){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the client Account Number which to Withdraw Money from: ");
        String accountToWithdrawMoney = scanner.nextLine();

        for (CurrentAccount currentAccount: currentAccounts){
            if(accountToWithdrawMoney.equals(currentAccount.getAccountHolderNumber())){
                System.out.print("Enter the Amount to Withdraw: ");
                double amountToWithdraw = scanner.nextDouble();
                currentAccount.withdraw(amountToWithdraw);
                System.out.println("Your current balance is KSH: "+currentAccount.getCurrentAccountBalance());
                System.out.println();
                currentAccount.displayAccountDetails();
                break;
            }else {
                System.out.println("No matching information for Withdrawal Account Number "+accountToWithdrawMoney);
            }
            scanner.close();
        }

    }

    public static void savingWithdraw(ArrayList<SavingsAccount> savingsAccounts){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the client Account Number which to Withdraw Money from: ");
        String accountToWithdrawMoney = scanner.nextLine();

        for (SavingsAccount savingsAccount: savingsAccounts){
            if(accountToWithdrawMoney.equals(savingsAccount.getAccountHolderNumber())){
                System.out.print("Enter the Amount to Withdraw: ");
                double amountToWithdraw = scanner.nextDouble();
                savingsAccount.withdraw(amountToWithdraw);
                System.out.println("Your current balance is KSH: "+savingsAccount.getAccountBalance());
                System.out.println();
                savingsAccount.displayAccountDetails();
                break;
            }else {
                System.out.println("No matching information for Withdrawal Account Number "+accountToWithdrawMoney);
            }
            scanner.close();
        }

    }
    public static void deposit(ArrayList<CurrentAccount> currentAccounts){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the client Account Number which to deposit Money to: ");
        String accountToDepositMoney = scanner.nextLine();

        for (CurrentAccount currentAccount: currentAccounts){
            if(accountToDepositMoney.equals(currentAccount.getAccountHolderNumber())){
                System.out.print("Enter the Amount to Deposit: ");
                double amountToDeposit = scanner.nextDouble();
                currentAccount.deposit(amountToDeposit);
                System.out.println("Your current balance is KSH: "+currentAccount.getCurrentAccountBalance());
                System.out.println();
                currentAccount.displayAccountDetails();
                scanner.nextLine();
                break;
            }else {
                System.out.println("No matching information for Account Number "+accountToDepositMoney+" .");
            }
            scanner.close();
        }

    }

    public static void savingAccountDeposit(ArrayList<SavingsAccount> savingsAccounts){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the client Account Number which to deposit Money to: ");
        String accountToDepositMoney = scanner.nextLine();

        for (SavingsAccount savingsAccount: savingsAccounts){
            if(accountToDepositMoney.equals(savingsAccount.getAccountHolderNumber())){
                System.out.print("Enter the Amount to Deposit: ");
                double amountToDeposit = scanner.nextDouble();
                savingsAccount.deposit(amountToDeposit);
                System.out.println("Your current balance is KSH: "+savingsAccount.getAccountBalance());
                System.out.println();
                savingsAccount.displayAccountDetails();
                scanner.nextLine();
                break;
            }else {
                System.out.println("No matching information for Account Number "+accountToDepositMoney+" .");
            }
            scanner.close();
        }

    }
    public static void getAccountsData(ArrayList<CurrentAccount> currentAccounts) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Accounts to register: ");
        int numberOfCurrentAccounts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfCurrentAccounts; i++) {
            System.out.println("Enter the Account for " + (i + 1) + " : ");
            System.out.print("Enter Account Holder Number: ");
            String accountHolderNumber = scanner.nextLine();
            System.out.print("Enter Account Holder ID: ");
            String accountHolderId = scanner.nextLine();
            System.out.print("Enter Account Holder Email Address: ");
            String accountHolderEmailAddress = scanner.nextLine();
            System.out.print("Enter Account Holder Telephone Number: ");
            String accountHolderTelephoneNumber = scanner.nextLine();
            System.out.print("Enter Account Holder Account Balance: ");
            double currentAccountBalance = scanner.nextDouble();
            scanner.nextLine();

            CurrentAccount currentAccount = new CurrentAccount(accountHolderNumber,accountHolderId,
                    accountHolderEmailAddress,accountHolderTelephoneNumber,currentAccountBalance);
            currentAccounts.add(currentAccount);

        }
    }

    public static void getSavingsAccountsData(ArrayList<SavingsAccount> savingsAccounts) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Accounts to register: ");
        int numberOfCurrentAccounts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfCurrentAccounts; i++) {
            System.out.println("Enter the Account for " + (i + 1) + " : ");
            System.out.print("Enter Account Holder Number: ");
            String accountHolderNumber = scanner.nextLine();
            System.out.print("Enter Account Holder ID: ");
            String accountHolderId = scanner.nextLine();
            System.out.print("Enter Account Holder Email Address: ");
            String accountHolderEmailAddress = scanner.nextLine();
            System.out.print("Enter Account Holder Telephone Number: ");
            String accountHolderTelephoneNumber = scanner.nextLine();
            System.out.print("Enter Account Holder Account Balance: ");
            double currentAccountBalance = scanner.nextDouble();
            scanner.nextLine();
            SavingsAccount savingsAccount = new SavingsAccount(accountHolderNumber,accountHolderId,
                    accountHolderEmailAddress,accountHolderTelephoneNumber,currentAccountBalance);
            savingsAccounts.add(savingsAccount);
        }
    }
    public static void getCurrentAccountsData(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();
        getAccountsData(currentAccounts);
        printDetails(currentAccounts);
        System.out.println();
        System.out.print("Do you want to Deposit or Withdraw.\n" +
                "Press 1 for Deposit or 2 for Withdrawal ");
        int actionType = scanner.nextInt();
        if (actionType ==1){
            deposit(currentAccounts);
        }else if(actionType==2) {
            withdraw(currentAccounts);
        }
        else {
            System.out.println("Invalid Input");
        }


    }
    public static void printDetails(ArrayList<CurrentAccount> accounts){
        System.out.println();
        System.out.println("Printing account Details");
        System.out.println("=======================================================");
        System.out.println();

        for (CurrentAccount currentAccount: accounts){
            currentAccount.displayAccountDetails();
        }

    }

    public static void printSavingDetails(ArrayList<SavingsAccount> accounts){
        System.out.println();
        System.out.println("Printing account Details");
        System.out.println("=======================================================");
        System.out.println();

        for (SavingsAccount savingsAccount: accounts){
            savingsAccount.displayAccountDetails();
        }

    }
    public static void getSavingsAccountsData() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SavingsAccount> savingsAccounts = new ArrayList<>();
        getSavingsAccountsData(savingsAccounts);
        printSavingDetails(savingsAccounts);
        System.out.println();
        while (true){

            System.out.print("Do you want to Deposit or Withdraw.\n" +
                    "Press 1 for Deposit or 2 for Withdrawal: ");
            int actionType = scanner.nextInt();
            if (actionType ==1){
                savingAccountDeposit(savingsAccounts);
            }else if(actionType==2) {
                savingWithdraw(savingsAccounts);
            }
            else {
                System.out.println("Invalid Input");
            }

            System.out.print("Do you want to Quit The Deposit or Withdraw Program.\nPress 1 to quit,press 2 to continue : ");
            int choice = scanner.nextInt();
            if(choice==1){
                break;
            }else if (choice == 2){
                continue;
            }else {
                System.out.println("Invalid Input");
            }

        }
    }
}
