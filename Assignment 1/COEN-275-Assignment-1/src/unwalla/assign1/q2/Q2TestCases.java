package unwalla.assign1.q2;

import unwalla.assign1.money.USMoney;
import unwalla.assign1.salebin.Bin;
import unwalla.assign1.salebin.SaleItem;
import unwalla.assign1.salebin.SmartBin;

public class Q2TestCases {

    public static void main(String[] args) {
        //Create Sale items to put in bin
        SaleItem item1 = new SaleItem("item1", new USMoney(50, 0), 60, true);
        SaleItem item2 = new SaleItem("item2",  new USMoney(72, 52), 70,false);
        SaleItem item3 = new SaleItem("item3",  new USMoney(10, 11), 10, true);
        SaleItem item4 = new SaleItem("item4",   new USMoney(13, 05), 94, false);
        SaleItem item5 = new SaleItem("item5",  new USMoney(18, 10), 53,true);

        Bin bin1 = new Bin();

        bin1.addItem(item1);
        bin1.addItem(item2);
        bin1.addItem(item3);
        bin1.addItem(item4);
        bin1.addItem(item5);

        System.out.println(bin1.showDetails());
        System.out.println("************************");

        //Create Sale items to put in smartBin
        SaleItem item6 = new SaleItem("item6", new USMoney(52, 3), 30, true);
        SaleItem item7 = new SaleItem("item7",  new USMoney(71, 62), 60,false);
        SaleItem item8 = new SaleItem("item8",  new USMoney(60, 13), 80, true);
        SaleItem item9 = new SaleItem("item9",   new USMoney(43, 45), 54, false);
        SaleItem item10 = new SaleItem("item10",  new USMoney(78, 15), 52,true);

        SmartBin bin2 = new SmartBin();

        bin2.addItem(item6);
        bin2.addItem(item7);
        bin2.addItem(item8);
        bin2.addItem(item9);
        bin2.addItem(item10);

        System.out.println(bin2.showDetails());
        System.out.println("************************");

        //The code creates an object of class SmartBin and assigns it to a reference of type Bin, hence we can add fragile items to it.
        Bin bin3 = new SmartBin();
        bin3.addItem(item6);
        bin3.addItem(item7);
        bin3.addItem(item8);
        bin3.addItem(item9);
        bin3.addItem(item10);
        System.out.println(bin3.showDetails());
        System.out.println("\nbin3 Can add fragile items");



    }
}
