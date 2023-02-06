//package unwalla.assign1.money;

public class USMoney {
    private double dollars;
    private double cents;

    public USMoney(double dollars, double cents) {
        this.dollars = dollars;
        if (cents < 0) {
            cents = 0;
        } else if (cents > 99) {
            this.dollars += cents / 100;
            cents = cents % 100;
        }
        this.cents = cents;
    }

    public USMoney() {
        this(0, 0);
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public void setCents(int cents) {
        if (cents < 0) {
            cents = 0;
        } else if (cents > 99) {
            this.dollars += cents / 100;
            cents = cents % 100;
        }
        this.cents = cents;
    }

    public double getDollars() {
        return dollars;
    }

    public double getCents() {
        return cents;
    }

    public void addTo(int dollars, int cents) {
        this.dollars += dollars;
        if (this.cents + cents > 99) {
            this.dollars += (this.cents + cents) / 100;
            this.cents = (this.cents + cents) % 100;
        } else {
            this.cents += cents;
        }
    }

    public USMoney add(USMoney money) {
        double newDollars = this.dollars + money.dollars;
        double newCents = this.cents + money.cents;
        if (newCents > 99) {
            newDollars += newCents / 100;
            newCents = newCents % 100;
        }
        return new USMoney(newDollars, newCents);
    }

    public String toString() {
        return "$" + dollars + "." + cents;
    }

    public static void main(String[] args) {
        USMoney m1 = new USMoney(15, 80);
        System.out.println(m1); // Should print $15.80
        m1.addTo(25, 100);
        System.out.println(m1); // Should print $41.80
        // USMoney m2 = m1.add(new USMoney(2.90));
        // System.out.println(m2); // Should print $44.70
        // System.out.println(m1); // Should print $41.80
    }
}
