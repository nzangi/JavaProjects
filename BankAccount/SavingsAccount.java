package BankAccount;

import java.text.SimpleDateFormat;
import java.util.Date;
public class SavingsAccount extends Account{
    public static int savingAccountWithdrawPerMonth=1;
    private double accountBalance;
    private final CurrentAccount currentAccount;
//    private final Date date;
    private Date lastWithdrawalDate;



    public SavingsAccount(String accountHolderNumber, String accountHolderId, String accountHolderEmailAddress, String accountHolderTelephoneNumber,double accountBalance) {
        super(accountHolderNumber, accountHolderId, accountHolderEmailAddress, accountHolderTelephoneNumber);
        this.accountBalance = accountBalance;
//        date = new Date();
        this.lastWithdrawalDate = new Date();
        this.currentAccount = new CurrentAccount(accountHolderNumber,accountHolderId,accountHolderEmailAddress,accountHolderTelephoneNumber,accountBalance);

    }


    @Override
    public void deposit(double amountToDeposit) {
        currentAccount.deposit(amountToDeposit);
    }

    @Override
    public  void withdraw(double amountToWithdraw) {
        if(canWithdraw()){
            currentAccount.withdraw(amountToWithdraw);
            System.out.println("Withdrawal successful. Your current balance is KSH: " + getAccountBalance());
            lastWithdrawalDate = new Date();
            savingAccountWithdrawPerMonth--;
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
        currentAccount.displayAccountDetails();

    }

    public double getAccountBalance() {
        return currentAccount.getAccountBalance();
    }

}
