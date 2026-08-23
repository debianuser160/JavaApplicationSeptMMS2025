    
package assignment8;


public abstract class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;
    
    public BankAccount(String accountHolder, String accountNumber, 
            double balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;   
    }
    
    void deposit(double amount){
        
    }
    
    void displayBalance(){
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
    
    abstract void withdraw();
    
    abstract void calculateInterest();
}
