package BankAccount;

import java.text.SimpleDateFormat;
import java.util.Date;

public  class Account {
    private String accountHolderNumber,accountHolderId;
    private String accountHolderEmailAddress,accountHolderTelephoneNumber;
    private double accountBalance;

    private  Date date;


    public Account(String accountHolderNumber,String accountHolderId,String
            accountHolderEmailAddress,String accountHolderTelephoneNumber,double accountBalance){
        this.accountHolderNumber = accountHolderNumber;
        this.accountHolderId = accountHolderId;
        this.accountHolderEmailAddress = accountHolderEmailAddress;
        this.accountHolderTelephoneNumber = accountHolderTelephoneNumber;
        this.accountBalance = accountBalance;
        date = new Date();
    }


    public void displayAccountDetails(){
        SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy hh:mm:ss a");
        System.out.println("Account Holder Number :"+accountHolderNumber);
        System.out.println("Account Holder Id : "+accountHolderId);
        System.out.println("Account Holder Email Address : "+accountHolderEmailAddress);
        System.out.println("Account Holder Telephone Number : "+accountHolderTelephoneNumber);
        System.out.println("Holder Account Balance (KSH): "+accountBalance);
        System.out.println("Account date of registration : "+formatter.format(date));
        System.out.println();
        System.out.println("=======================================================");

    }
    public Date getDate() {
        return date;
    }

    public void deposit(double amountToDeposit){
        accountBalance += amountToDeposit;

    }
    public void withdraw( double amountToWithdraw){
        if(accountBalance >=amountToWithdraw){
            accountBalance -= amountToWithdraw;
        }else {
            System.out.println("You dont have suffices funds to withdraw "+amountToWithdraw+" from your account." +
                    "Your account balance is "+ accountBalance);
        }
    }

    public void setAccountHolderNumber(String accountHolderNumber) {
        this.accountHolderNumber = accountHolderNumber;
    }

    public String getAccountHolderNumber() {
        return accountHolderNumber;
    }

    public void setAccountHolderId(String accountHolderId) {
        this.accountHolderId = accountHolderId;
    }

    public String getAccountHolderId() {
        return accountHolderId;
    }

    public String getAccountHolderEmailAddress() {
        return accountHolderEmailAddress;
    }

    public String getGetAccountHolderTelephoneNumber() {
        return accountHolderTelephoneNumber;
    }

    public void setAccountHolderEmailAddress(String accountHolderEmailAddress) {
        this.accountHolderEmailAddress = accountHolderEmailAddress;
    }

    public void setGetAccountHolderTelephoneNumber(String accountHolderTelephoneNumber) {
        this.accountHolderTelephoneNumber = accountHolderTelephoneNumber;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }
}
