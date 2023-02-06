package unwalla.assign1.q1;

import unwalla.assign1.money.USMoney;

/**
 * USMoneyTester class tests the functionality of the USMoney class.
 * It creates instances of the USMoney class and calls its methods to verify its functionality.
 *
 * @author Husain Unwalla
 * @version 1.0
 */

public class USMoneyTester {
    public static void main(String[] args) {
        USMoney amt1 = new USMoney();
        System.out.println(amt1);
        amt1.setCents(250);
        System.out.println(amt1);
        amt1.setDollars(10);
        System.out.println(amt1);
        System.out.println(amt1.getCents());
        USMoney amt2 = amt1.add(new USMoney(2, 90));
        System.out.println(amt1);
        System.out.println(amt2);
        amt2.addTo(amt1.getDollars(), amt1.getCents());
        System.out.println(amt2);
        USMoney amt3 = new USMoney(99, 120);
        amt3.addTo(99, 120);
        System.out.println(amt3);
    }
}
