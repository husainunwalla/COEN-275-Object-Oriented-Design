package unwalla.assign1.money;

/**
 * The USMoney class represents a monetary value in the United States currency system.
 * It contains two instance variables, dollars and cents, that represent the value of the money.
 *
 * @author Husain Unwalla
 * @version 1.0
 */
public class USMoney {
    private int dollars;
    private int cents;

    /**
     * Constructor that takes two parameters, dollars and cents, and initializes the corresponding data members.
     * The constructor checks that the cents value is between 0 and 99, and if not, transfers some of the cents to
     * the dollars to make it between 0 and 99.
     *
     * @param dollars The number of dollars
     * @param cents The number of cents
     */
    public USMoney(int dollars, int cents) {
        this.dollars = dollars;
        if (cents < 0) {
            cents = 0;
        } else if (cents > 99) {
            this.dollars += cents / 100;
            cents = cents % 100;
        }
        this.cents = cents;
    }

    /**
     * Default constructor that initializes the data members to 0.
     */
    public USMoney() {
        this(0, 0);
    }

    /**
     * Setter method to set the dollars.
     *
     * @param dollars The number of dollars to set
     */
    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    /**
     * Setter method to set the cents.
     *
     * @param cents The number of cents to set
     */
    public void setCents(int cents) {
        if (cents < 0) {
            cents = 0;
        } else if (cents > 99) {
            this.dollars += cents / 100;
            cents = cents % 100;
        }
        this.cents = cents;
    }

    /**
     * Getter method to return the number of dollars.
     *
     * @return The number of dollars
     */
    public int getDollars() {
        return dollars;
    }

    /**
     * Getter method to return the number of cents.
     *
     * @return The number of cents
     */
    public int getCents() {
        return cents;
    }

    /**
     * Adds the parameter values, dollars and cents, to the data members.
     *
     * @param dollars The number of dollars to add
     * @param cents The number of cents to add
     */
    public void addTo(int dollars, int cents) {
        this.dollars += dollars;
        if (this.cents + cents > 99) {
            this.dollars += (this.cents + cents) / 100;
            this.cents = (this.cents + cents) % 100;
        } else {
            this.cents += cents;
        }
    }

    /**
     * Creates and returns a new USMoney object representing the sum of the object whose add() is invoked
     * and the object passed as parameter.
     *
     * @param money The USMoney object to add
     * @return A new USMoney object representing the sum
     */
    public USMoney add(USMoney money) {
        int newDollars = this.dollars + money.dollars;
        int newCents = this.cents + money.cents;
        if (newCents > 99) {
            newDollars += newCents / 100;
            newCents = newCents % 100;
        }
        return new USMoney(newDollars, newCents);
    }

    /**
     * Returns a string representation of the object in the format "$dollars.cents".
     *
     * @return A string representation of the object
     */
    public String toString() {
        return "$" + dollars + "." + cents;
    }

    public static void main(String[] args) {
        USMoney m1 = new USMoney (15,80);
        System.out.println (m1);  // Should print $15.80
        m1.addTo(25,100);
        System.out.println (m1);    // Should print $41.80
        USMoney m2 = m1.add( new USMoney (2, 90));
        System.out.println (m2);    // Should print $44.70
        System.out.println (m1);    // Should print $41.80
    }

}
