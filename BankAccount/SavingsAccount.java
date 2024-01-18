package BankAccount;

import java.text.SimpleDateFormat;
import java.util.Date;
public class SavingsAccount extends Account{
    public static int savingAccountWithdrawPerMonth=1;
    private double accountBalance;
    private final Date date;
    private Date lastWithdrawalDate;



    public SavingsAccount(String accountHolderNumber, String accountHolderId, String accountHolderEmailAddress, String accountHolderTelephoneNumber,double accountBalance) {
        super(accountHolderNumber, accountHolderId, accountHolderEmailAddress, accountHolderTelephoneNumber);
        this.accountBalance = accountBalance;
        date = new Date();
        this.lastWithdrawalDate = new Date();

    }


    @Override
    public void deposit(double amountToDeposit) {
        if (amountToDeposit > 0){
            accountBalance += amountToDeposit;
            System.out.println("Deposit of "+amountToDeposit+" was successful");

        }else {
            System.out.println("Deposit of "+amountToDeposit+" was not successful");

        }
    }

    @Override
    public  void withdraw(double amountToWithdraw) {
        if(savingAccountWithdrawPerMonth== 1 || canWithdraw()){
            if(amountToWithdraw > 0 && accountBalance >=amountToWithdraw){
                accountBalance -= amountToWithdraw;
                System.out.println("Withdrawal of "+amountToWithdraw+" was successful");
                lastWithdrawalDate = new Date();
                savingAccountWithdrawPerMonth--;

            }else {
                System.out.println("You don't have sufficient funds to withdraw "+amountToWithdraw+" from your account." +
                        "Your account balance is "+ accountBalance);
            }

        }else {
            System.out.println("Sorry, you can only make 1 withdrawal per 30 days in saving account.");
        }

    }
    private boolean canWithdraw(){
        return  savingAccountWithdrawPerMonth > 0 && daysBetween(lastWithdrawalDate,new Date()) >=30;
    }
    private long daysBetween(Date startDate,Date endDate){
        long daysDifference = endDate.getTime() - startDate.getTime();
        return  daysDifference / (24*60*60*100);

    }
    public void displayAccountDetails(){
        SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy hh:mm:ss a");
        System.out.println("Account Holder Number :"+getAccountHolderNumber());
        System.out.println("Account Holder Id : "+getAccountHolderId());
        System.out.println("Account Holder Email Address : "+getAccountHolderEmailAddress());
        System.out.println("Account Holder Telephone Number : "+getAccountHolderTelephoneNumber());
        System.out.println("Holder Saving Account Balance (KSH): "+accountBalance);
        System.out.println("Account date of registration : "+formatter.format(date));
        System.out.println();
        System.out.println("=======================================================");

    }

    public double getAccountBalance() {
        return accountBalance;
    }

}
