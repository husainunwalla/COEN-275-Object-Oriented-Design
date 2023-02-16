package assign2;

import java.util.ArrayList;
import java.util.Collection;

/**
 This class represents an ATM machine with bank account functionality.
 */
public class ATM {

    /*
    Collection of bank accounts that are associated with this ATM machine.
    */
    private final Collection<BankAccount> accounts;

    /**
     Encryptor used to encode and decode passwords for bank accounts associated with this ATM machine.
     */
    private final Encryptor passwordEncoder;

    /**
     Constructs an instance of the ATM class with an empty collection of accounts and an encryptor with a key length of 10.
     */
    public ATM() {
        accounts = new ArrayList<>();
        passwordEncoder = new Encryptor(10);
    }

    /**
     Adds a new bank account to the collection of accounts associated with this ATM machine.
     @param acctId the ID of the account to add
     @param name the name of the account holder
     @param balance the starting balance of the account
     @param password the password for the account
     */
    public void addAccount(String acctId, String name, double balance, String password) {
        String encryptedPassword = passwordEncoder.encrypt(password);
        BankAccount newAccount = new BankAccount(acctId, name, balance, encryptedPassword);
        accounts.add(newAccount);
    }

    /**
     Attempts to withdraw money from the specified account if the account exists and the password is correct.
     @param acctId the ID of the account to withdraw from
     @param password the password for the account
     @param amount the amount to withdraw
     @return the amount that was successfully withdrawn from the account, or 0.0 if the withdrawal was unsuccessful
     */
    public double getMoney(String acctId, String password, double amount) {
        for (BankAccount account : accounts) {
            if (account.getAccntId().equals(acctId)) {
                String decryptedPassword = passwordEncoder.decrypt(account.getPassword());
                if (password.equals(decryptedPassword)) {
                    return account.withdraw(amount);
                } else {
                    System.out.println("Incorrect password.");
                    return 0.0;
                }
            }
        }
        System.out.println("Account not found.");
        return 0.0;
    }

    /**
     Main method for testing the ATM class.
     @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // 1. Create an instance of ATM.
        ATM atm = new ATM();

        // 2. Call the addAccount() with the following values for parameters:
        // acctId: A123 name: M.Jones password: fall-quarter balance: 2000.00
        atm.addAccount("A123", "M.Jones", 2000.00, "fall-quarter");

        // 3. Call the addAccount() with the following values for parameters:
        // acctId: B654 name: B.Smith password: renaissance balance: 100.00
        atm.addAccount("B654", "B.Smith", 100.00, "renaissance");

        // 4. Call the getMoney() with the following values for parameters:
        // acctId: A123 password: fall-quarter amount: 1000.00
        double withdrawn1 = atm.getMoney("A123", "fall-quarter", 1000.00);
        System.out.println("Withdrawn from A123: " + withdrawn1);

        // 5. Call the getMoney() with the following values for parameters:
        // acctId: B654 password: essence amount: 100.00
        double withdrawn2 = atm.getMoney("B654", "essence", 100.00);
        System.out.println("Withdrawn from B654: " + withdrawn2);

        // 6. Call the getMoney() with the following values for parameters:
        // acctId: B654 password: renaissance amount: 50.00
        double withdrawn3 = atm.getMoney("B654", "renaissance", 50.00);
        System.out.println("Withdrawn from B654: " + withdrawn3);

        // 7. Call the getMoney() with the following values for parameters:
        // acctId: B654 password: renaissance amount: 50.00
        double withdrawn4 = atm.getMoney("B654", "renaissance", 50.00);
        System.out.println("Withdrawn from B654: " + withdrawn4);

        // 8. Call the getMoney() with the following values for parameters:
        // acctId: B654 password: renaissance amount: 50.00
        double withdrawn5 = atm.getMoney("B654", "renaissance", 50.00);
        System.out.println("Withdrawn from B654: " + withdrawn5);

        // 9. Call the addAccount() with the following values for parameters:
        // acctId: A123 name: M.Jones password: fall-quarter balance: 1000.00
        atm.addAccount("A123", "M.Jones", 1000.00, "fall-quarter");
    }

}
