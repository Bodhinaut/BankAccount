
/**
 *  Kyle M. Shive 
 */
public class CheckingAccount extends BankAccount{
    private boolean hasFreeChecks;
    private String linkedSavingsAccount;
    
    public CheckingAccount (String accountNumber, String ownerFirstName, String ownerLastName,
    double currentBalance, double minimumBalanceRequired, boolean hasFreeChecks, 
    String linkedSavingsAccount){
        super(accountNumber, ownerFirstName, ownerLastName, currentBalance, minimumBalanceRequired);
        setHasFreeChecks(hasFreeChecks);
        setLinkedSavingsAccount(linkedSavingsAccount);
    }// end arg ctr
    
    public boolean getHasFreeChecks       () {return hasFreeChecks;}
    public String getLinkedSavingsAccount () {return linkedSavingsAccount;}
    
    public void setHasFreeChecks (boolean hasFreeChecks) {
        this.hasFreeChecks = hasFreeChecks;
    }// end freee checks setter 
    
    public void setLinkedSavingsAccount (String linkedSavingsAccount) {
        this.linkedSavingsAccount = linkedSavingsAccount;
    }// end linked savings setter 
    
    @Override
    public String toString() {
    String str = "";
    
    str += "C," + super.toString();
    str += "," + hasFreeChecks + "," + linkedSavingsAccount;
    
    return str;
    }// end descriptor
    
}// end checking class 
