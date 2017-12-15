
/**
 * Kyle M. Shive 
 */
public class BankAccount {
    private String accountNumber;
    private String ownerFirstName;
    private String ownerLastName;
    private double currentBalance; 
    private double minimumBalanceRequired;
    
    public BankAccount (String accountNumber, String ownerFirstName, String ownerLastName,
                                   double currentBalance, double minimumBalanceRequired) {
    setAccountNumber(accountNumber);
    setOwnerFirstName(ownerFirstName);
    setOwnerLastName(ownerLastName);
    setCurrentBalance(currentBalance);
    setMinimumBalanceRequired(minimumBalanceRequired);                       
    }// end arg ctr
    
    public String getAccountNumber          () {return accountNumber;}
    public String getOwnerFirstName         () {return ownerFirstName;}
    public String getOwnerLastName          () {return ownerLastName;}
    public String getOwnerName              () {return ownerFirstName + " " + ownerLastName;}
    public double getCurrentBalance         () {return currentBalance;}
    public double getMinimumBalanceRequired () {return minimumBalanceRequired;}
    
    public void setAccountNumber (String accountNumber)     {this.accountNumber = accountNumber;}
    public void setOwnerFirstName (String ownerFirstName) {this.ownerFirstName = ownerFirstName;}
    public void setOwnerLastName (String ownerLastName)     {this.ownerLastName = ownerLastName;}
    public void setOwnerName (String ownerFirstName, String ownerLastName) {
                       this.ownerFirstName = ownerFirstName; this.ownerLastName = ownerLastName;}
    public void setCurrentBalance (double currentBalance) {
        if (currentBalance < 0) {
            System.out.println("Current Balance not updated due to invalid negative amount");
        }else
            this.currentBalance = currentBalance;
    }// end setCurrentBalance
    
    public void setMinimumBalanceRequired (double minimumBalanceRequired) {
        if (minimumBalanceRequired < 0) {
            System.out.println("Minimum Balance not updated due to invalid negative amount");
        }else
        this.minimumBalanceRequired = minimumBalanceRequired;
    }// end setMinBalanceReq
                                           
    public double deposit (double amount) {
        if (amount <= 0) {
            System.out.println("Invalid input, balance not updated due to negative amount");
        } else {
            currentBalance = currentBalance + amount;
        }
        return currentBalance;
    }// end deposit method                 
    
     public double withdraw (double amount) {
        if (amount < 0) {
            System.out.println("Invalid input, balance not updated due to negative amount");
        } else if (amount >= currentBalance) {
            currentBalance = currentBalance - 50;
        } else {
            currentBalance = currentBalance - amount;
        }
        return currentBalance;
    }// end withdraw method
                                         
    @Override
    public String toString() {
    String str = "";
    
    str += accountNumber + "," + ownerFirstName + "," + ownerLastName + "," + 
    String.format("%.2f", currentBalance) + "," + String.format("%.2f", minimumBalanceRequired);
    
    return str;
    }// end descriptor
                                 
}// end class Bankaccount
