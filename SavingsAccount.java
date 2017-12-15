
/**
 *  Kyle M. Shive 
 */
public class SavingsAccount extends BankAccount {
   private double annualInterestRate;
   private int numberOfFreeTransactions;
   
   public SavingsAccount (String accountNumber, String ownerFirstName, String ownerLastName,
   double currentBalance, double minimumBalanceRequired, double annualInterestRate, 
   int numberOfFreeTransactions){
    super(accountNumber, ownerFirstName, ownerLastName, currentBalance, minimumBalanceRequired);    
    setAnnualInterestRate(annualInterestRate);
    setNumberOfFreeTransactions(numberOfFreeTransactions);
    }// end arg ctr
    
   public double getAnnualInterestRate    () {return annualInterestRate;}
   public int getNumberOfFreeTransactions () {return numberOfFreeTransactions;}
   
   public void setAnnualInterestRate (double annualInterestRate) {
       if (annualInterestRate < 0) {
           System.out.println("Invalid amount entered, please try again.");
       }else
       this.annualInterestRate = annualInterestRate;
   }// end set annual interest
   
   public void setNumberOfFreeTransactions (int numberOfFreeTransactions) {
       if (numberOfFreeTransactions < 0) {
           System.out.println("You cannot have negative free transactions, please try again.");
       }else
       this.numberOfFreeTransactions = numberOfFreeTransactions;
   }// end setter free transactions 
   
   public double payMonthlyInterest () {
       setCurrentBalance(getCurrentBalance() + getCurrentBalance() * (annualInterestRate / 12) );
       return getCurrentBalance();
   }// end monthly interest mehtod 
   
   @Override
    public String toString() {
    String str = "";
    
    str += "S," + super.toString();
    str += "," + String.format("%.2f", annualInterestRate) + "," + numberOfFreeTransactions;
    
    return str;
    }// end descriptor
}
