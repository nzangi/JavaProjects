package BankAccount;

import java.util.Date;

public  abstract class Account {
    private final String accountHolderNumber;
    private final String accountHolderId;
    private final String accountHolderEmailAddress;
    private final String accountHolderTelephoneNumber;
//    private double accountBalance;


    public Account(String accountHolderNumber,String accountHolderId,String
            accountHolderEmailAddress,String accountHolderTelephoneNumber){
        this.accountHolderNumber = accountHolderNumber;
        this.accountHolderId = accountHolderId;
        this.accountHolderEmailAddress = accountHolderEmailAddress;
        this.accountHolderTelephoneNumber = accountHolderTelephoneNumber;
    }



    public abstract void deposit(double amountToDeposit);
    public abstract void withdraw( double amountToWithdraw);

    public String getAccountHolderNumber() {
        return accountHolderNumber;
    }

    public String getAccountHolderId() {
        return accountHolderId;
    }

    public String getAccountHolderEmailAddress() {
        return accountHolderEmailAddress;
    }

    public String getAccountHolderTelephoneNumber() {
        return accountHolderTelephoneNumber;
    }


}
