package BankAccount;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentAccount extends Account{
    private double currentAccountBalance;
    private Date date;

    public CurrentAccount(String accountHolderNumber, String accountHolderId,String accountHolderEmailAddress, String accountHolderTelephoneNumber,double currentAccountBalance) {
        super(accountHolderNumber, accountHolderId,accountHolderEmailAddress,accountHolderTelephoneNumber);
        this.currentAccountBalance = currentAccountBalance;
        date = new Date();

    }

    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    @Override
    public void deposit(double amountToDeposit){
        if (amountToDeposit > 0){
            currentAccountBalance += amountToDeposit;
            System.out.println("Deposit of "+amountToDeposit+" was successful");

        }else {
            System.out.println("Deposit of "+amountToDeposit+" was not successful");

        }

    }

    @Override
    public void withdraw( double amountToWithdraw){
        if(amountToWithdraw > 0 && currentAccountBalance >=amountToWithdraw){
            currentAccountBalance -= amountToWithdraw;
            System.out.println("Withdrawal of "+amountToWithdraw+" was successful");

        }else {
            System.out.println("You dont have suffices funds to withdraw "+amountToWithdraw+" from your account." +
                    "Your account balance is "+ currentAccountBalance);
        }
    }

    public void displayAccountDetails(){
        SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy hh:mm:ss a");
        System.out.println("Account Holder Number :"+getAccountHolderNumber());
        System.out.println("Account Holder Id : "+getAccountHolderId());
        System.out.println("Account Holder Email Address : "+getAccountHolderEmailAddress());
        System.out.println("Account Holder Telephone Number : "+getAccountHolderTelephoneNumber());
        System.out.println("Holder Account Balance (KSH): "+currentAccountBalance);
        System.out.println("Account date of registration : "+formatter.format(date));
        System.out.println();
        System.out.println("=======================================================");

    }

}
