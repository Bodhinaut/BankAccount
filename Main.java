import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    private static final int FIELD_ACCOUNT_TYPE = 0;
    private static final int FIELD_ACCOUNT_NUMBER = 1;
    private static final int FIELD_OWNER_FIRST_NAME = 2;
    private static final int FIELD_OWNER_LAST_NAME = 3;
    private static final int FIELD_CURRENT_BALANCE = 4;
    private static final int FIELD_MINIMUM_BALANCE_REQUIRED = 5;
    private static final int FIELD_HAS_FREE_CHECKS = 6;
    private static final int FIELD_ANNUAL_INTEREST_RATE = 6;
    private static final int FIELD_LINKED_SAVINGS_ACCOUNT = 7;
    private static final int FIELD_NUMBER_OF_FREE_TRANSACTIONS = 7;
    
    private static ArrayList<BankAccount> bank;
    
    public static void main(String[] args) {
        try {
            bank = new ArrayList<>();
            
            loadAccountsFromFile("accounts.txt");
            processTransactions();
            writeAccountsToFile("processed.txt");
            
        } catch (FileNotFoundException e) {
            System.out.println( "File: " + e.getMessage() );
        }
    }// end main()
    
    public static void loadAccountsFromFile(String filename) throws FileNotFoundException {
        try ( Scanner fin = new Scanner( new File(filename) ); ) {
            String record;
            String[] fields;
            
            while ( fin.hasNext() ) {
                record = fin.nextLine();
                fields = record.split(",");
                
                /* Decide what type of account we are creating. */
                if ( fields[FIELD_ACCOUNT_TYPE].equals("C") ) {
                    /* Create a checking account */
                    bank.add( new CheckingAccount(fields[FIELD_ACCOUNT_NUMBER],
                                                  fields[FIELD_OWNER_FIRST_NAME],
                                                  fields[FIELD_OWNER_LAST_NAME],
                                                  Double.parseDouble(fields[FIELD_CURRENT_BALANCE]),
                                                  Double.parseDouble(fields[FIELD_MINIMUM_BALANCE_REQUIRED]),
                                                  Boolean.parseBoolean(fields[FIELD_HAS_FREE_CHECKS]),
                                                  fields[FIELD_LINKED_SAVINGS_ACCOUNT]) );
                    
                } else {
                    /* Create a savings account */
                    bank.add( new SavingsAccount( fields[FIELD_ACCOUNT_NUMBER],
                                                  fields[FIELD_OWNER_FIRST_NAME],
                                                  fields[FIELD_OWNER_LAST_NAME],
                                                  Double.parseDouble(fields[FIELD_CURRENT_BALANCE]),
                                                  Double.parseDouble(fields[FIELD_MINIMUM_BALANCE_REQUIRED]),
                                                  Double.parseDouble(fields[FIELD_ANNUAL_INTEREST_RATE]),
                                                  Integer.parseInt(fields[FIELD_NUMBER_OF_FREE_TRANSACTIONS]) ) );
                }
            }
        }
    }// end loadAccountsFromFile()
    
    public static void processTransactions() {
        /* pay the monthly interest first to all savings account holders */
        for (BankAccount account : bank) {
            if (account instanceof SavingsAccount) {
                SavingsAccount sa =  (SavingsAccount)account;
                sa.payMonthlyInterest();
            }
        }
        
        /* Now, make a few deposits. We will assume we know the position of each account in the array list. */
        ( (CheckingAccount) bank.get(0) ).deposit(300.0);
        ( (SavingsAccount) bank.get(2) ) .deposit(1000.0);
        
        /* Now make some withdrawals. */
        ( (SavingsAccount) bank.get(5) ).withdraw(5000.0);
        ( (CheckingAccount) bank.get(6) ).withdraw(500.0);
    }// end processTransactions()
    
    public static void writeAccountsToFile(String filename) throws FileNotFoundException {
        try ( PrintWriter pw = new PrintWriter(filename); ) {
            
            for (BankAccount account : bank) {
                pw.println(account);
            }
        }
    }// end writeAccountsToFile()
}// end Main