------------------------------------------------------------------------
This is the project README file. 
This app focuses on inheritance. It is to be used by a bank for the management of 
accounts. The application tracks two types of accounts, 
SavingsAccount and CheckingAccount. These two classes are the subclasses 
for the design. The class BankAccount is the superclass.
The program reads an input file provided, accounts.txt containing account 
information and creates objects of the subclass types. 
The Mainclass  performs some transactions(deposit, withdraw, pay interest), 
and each account is updated accordingly. 
The updated accounts are then saved to the output file processed.txt.
------------------------------------------------------------------------

PROJECT TITLE: BankAccount
PURPOSE OF PROJECT: Hold user information and do basic transactions for a bank
VERSION or DATE: October 3, 2017
HOW TO START THIS PROJECT: Right click on the Main method in BlueJ IDE
run the Main,
AUTHORS: Kyle M. Shive 
USER INSTRUCTIONS: A provided input file is read, the data processed, and then
outputed to an output file called processed.txt. It contains the client' bank 
account information. 

Below is the UML for the program 

------------------------------------------------------------------------------------------------
                                           BankAccount
------------------------------------------------------------------------------------------------
-accountNumber: String
-ownerFirstName: String
-ownerLastName: String
-currentBalance: double
-minimumBalanceRequired: double
------------------------------------------------------------------------------------------------
+BankAccount(accountNumber: String,
                            ownerFirstName: String, ownerLastName: String,
                            currentBalance: double, minimumBalanceRequired: double)

+getAccountNumber(): String
+getOwnerFirstName(): String
+getOwnerLastName(): String
+getOwnerName(): String
+getCurrentBalance(): double
+getMinimumBalanceRequired(): double

+setAccountNumber(accountNumber: String): void
+setOwnerFirstName(ownerFirstName: String): void
+setOwnerLastName(ownerLastName: String): void
+setOwnerName(ownerFirstName: String, ownerLastName: String): void
+setCurrentBalance(currentBalance: double): void
+setMinimumBalanceRequired(minimumBalanceRequired: double): void

+deposit(amount: double): double
+withdraw(amount: double): double

+toString(): String <<Override>>
------------------------------------------------------------------------------------------------


------------------------------------------------------------------------------------------------
                                           SavingsAccount
------------------------------------------------------------------------------------------------
-annualInterestRate: double
-numberOfFreeTransactions: int
------------------------------------------------------------------------------------------------
+SavingsAccount(accountNumber: String, 
                                 ownerFirstName: String, ownerLastName: String,
                                 currentBalance: double, minimumBalanceRequired: double,
                                 annualInterestRate: double, numberOfFreeTransactions: int)

+getAnnualInterestRate(): double
+getNumberOfFreeTransactions(): int

+setAnnualInterestRate(annualInterestRate: double): void
+setNumberOfFreeTransactions(numberOfFreeTransactions: int): void

+payMonthlyInterest(): double

+toString(): String <<Override>>
------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------
                                           CheckingAccount
------------------------------------------------------------------------------------------------
-hasFreeChecks: boolean
-linkedSavingsAccount: String
------------------------------------------------------------------------------------------------
+CheckingAccount(accountNumber: String, 
                                   ownerFirstName: String, ownerLastName: String,
                                   currentBalance: double, minimumBalanceRequired: double,
                                   boolean hasFreeChecks, String linkedSavingsAccount)

+getHasFreeChecks(): boolean
+getLinkedSavingsAccount(): String

+setHasFreeChecks(hasFreeChecks: boolean): void
+setLinkedSavingsAccount(linkedSavingsAccount: String): void

+toString(): String <<Override>>
------------------------------------------------------------------------------------------------
