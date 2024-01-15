package BankAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        getCurrentAccountsData();


    }
    public static void getCurrentAccountsData(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Accounts to register: ");
        int numberOfCurrentAccounts = scanner.nextInt();
        scanner.nextLine();
        ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();

        for (int i = 0;i < numberOfCurrentAccounts;i++){
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
            double currentAccountBalance = scanner.nextDouble();
            scanner.nextLine();

            CurrentAccount currentAccount = new CurrentAccount(accountHolderNumber,accountHolderId,
                    accountHolderEmailAddress,accountHolderTelephoneNumber,currentAccountBalance);
            currentAccounts.add(currentAccount);

        }
        System.out.println();
        System.out.println("Printing account Details");
        System.out.println("=======================================================");
        System.out.println();

        for (CurrentAccount currentAccount: currentAccounts){
            currentAccount.displayAccountDetails();
        }

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
                System.out.println("No matching information for Withdrawal Account Number "+accountToDepositMoney);
            }
            scanner.close();
        }




    }

}
