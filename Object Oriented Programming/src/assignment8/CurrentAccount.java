
package assignment8;

public class CurrentAccount extends BankAccount{

    public CurrentAccount(String accountHolder, String accountNumber, 
            double balance) {
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
