package BankAccount;

public class CurrentAccount extends Account{
    private double currentAccountBalance;
    public CurrentAccount(String accountHolderNumber, String accountHolderId, double currentAccountBalance) {
        super(accountHolderNumber, accountHolderId,"","", currentAccountBalance);
    }

    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    @Override
    public void deposit(double amountToDeposit){
        double currentBalance = getAccountBalance();

        currentAccountBalance += amountToDeposit;

    }
    @Override
    public void withdraw( double amountToWithdraw){
        if(currentAccountBalance >=amountToWithdraw){
            currentAccountBalance -= amountToWithdraw;
        }else {
            System.out.println("You dont have suffices funds to withdraw "+amountToWithdraw+" from your account." +
                    "Your account balance is "+ currentAccountBalance);
        }
    }

}
