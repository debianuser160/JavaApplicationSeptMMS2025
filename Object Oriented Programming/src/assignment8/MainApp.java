
package assignment8;


public class MainApp {

    public static void main(String[] args){
        SavingsAccount savingsAccount = new SavingsAccount("Remielle Dan", "08060660272", 27.2);
        CurrentAccount currentAccount = new CurrentAccount("Osimhen", "08030223232", 89);
        
        System.out.println("=====Savings account balance=====");
        System.out.println("Balance: " + savingsAccount.balance);
        System.out.print("Interest: "); 
        savingsAccount.calculateInterest();
        
        System.out.println("=====Current Account balance=====");
        System.out.println("Balance: " + currentAccount.balance);
        System.out.print("Interest: ");
        currentAccount.calculateInterest();
        
        
    }     
}
