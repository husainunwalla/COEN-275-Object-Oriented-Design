package assign2;

/**
 The BankAccount class represents a simple bank account with an account ID, account holder name, balance, and password.
 */
public class BankAccount {
    private final String accntId;
    private final String name;
    private double balance;
    private final String password;

    /**
     Creates a new BankAccount object with the given account ID, account holder name, balance, and password.
     @param accntId the account ID of the bank account
     @param name the name of the account holder
     @param balance the balance of the bank account
     @param password the password for accessing the bank account
     */
    public BankAccount(String accntId, String name, double balance, String password) {
        this.accntId = accntId;
        this.name = name;
        this.balance = balance;
        this.password = password;
    }

    /**
     Returns the account ID of the bank account.
     @return the account ID of the bank account
     */
    public String getAccntId() {
        return accntId;
    }

    /**
     Returns the name of the account holder.
     @return the name of the account holder
     */
    public String getName() {
        return name;
    }

    /**
     Returns the current balance of the bank account.
     @return the current balance of the bank account
     */
    public double getBalance() {
        return balance;
    }

    /**
     Returns the password for accessing the bank account.
     @return the password for accessing the bank account
     */
    public String getPassword() {
        return password;
    }

    /**
     Withdraws the specified amount from the bank account, if possible.
     @param amount the amount to withdraw
     @return the amount withdrawn, or 0 if the withdrawal was not successful
     */
    public double withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return amount;
        } else {
            System.out.println("Invalid amount or insufficient balance");
            return 0;
        }
    }

    /**
     Deposits the specified amount into the bank account, if possible.
     @param amount the amount to deposit
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
