
package assignment8;


public class SavingsAccount extends BankAccount{

    public SavingsAccount(String accountHolder, String accountNumber, double balance) {
        super(accountHolder, accountNumber, balance);
    }

    @Override
    void withdraw() {
        System.out.println(accountHolder + " withdrew Money");
    }

    @Override
    void calculateInterest() {
        double interest = (balance * 0.02 * 2) / 100;
        System.out.println(interest);
    }
    
}
