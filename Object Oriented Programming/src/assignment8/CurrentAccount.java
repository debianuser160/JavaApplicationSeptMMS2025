
package assignment8;

public class CurrentAccount extends BankAccount{

    public CurrentAccount(String accountHolder, int accountNumber, double balance) {
        super(accountHolder, accountNumber, balance);
    }

    CurrentAccount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    void withdraw() {
        System.out.println(accountHolder + " withdrew Money");
    }

    @Override
    void calculateInterest() {
        System.out.println("Interest calculated");
    }
    
}
