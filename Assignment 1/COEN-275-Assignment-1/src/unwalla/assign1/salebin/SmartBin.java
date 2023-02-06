package unwalla.assign1.salebin;

import unwalla.assign1.money.USMoney;


import java.util.Arrays;

/**
 * Class representing a SmartBin. A SmartBin is a type of Bin that has additional
 * functionality compared to a regular Bin. A SmartBin has a label that can be
 * set and also has the ability to add an extra cost for fragile items.
 *
 * @author Husain Unwalla
 */
public class SmartBin extends Bin {

    /** The label for the SmartBin */
    private String label;

    /**
     * Constructor for the SmartBin. The binNumber for the SmartBin should start with "SM" followed
     * by a unique integer, generated using the generateBinNumber() method.
     */
    public SmartBin() {
        super();
        this.binNumber = "SM" + generateBinNumber();
    }

    /**
     * Set the label for the SmartBin.
     *
     * @param label the label to set for the SmartBin.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Adds an item to the SmartBin. If adding the item to the SmartBin does not exceed the
     * maxWeight of the Bin and if the item is not fragile, adds it to the items array. If the
     * added item is fragile, sets the bin's label to "Fragile - Handle with Care".
     *
     * @param item the item to add to the SmartBin.
     */
    @Override
    public void addItem(ItemType item) {
        if (getWeight() + item.getWeight() <= maxWeight) {
            ItemType[] newItems = Arrays.copyOf(items, items.length + 1);
            newItems[newItems.length - 1] = item;
            items = newItems;
            if (item.isFragile()) {
                this.label = "Fragile - Handle with Care";
            }
        }
    }

    /**
     * Calculates the total price of all items in the items array and adds $100.00 as the bin cost.
     * If there are fragile items in the bin, adds $10 extra for each of the fragile items. Returns
     * the total price.
     *
     * @return the total price for the items in the SmartBin.
     */
    @Override
    public USMoney calculatePrice() {
        USMoney totalCost = new USMoney(100, 0);
        for (ItemType item : items) {
            totalCost = totalCost.add(item.getPrice());
        }
        int fragileItemsCount = 0;
        for (ItemType item : items) {
            if (item.isFragile()) {
                fragileItemsCount++;
            }
        }
        totalCost = totalCost.add(new USMoney(10 * fragileItemsCount, 0));
        return totalCost;
    }

    /**
     * Returns a string by concatenating the binNumber, label, currentWeight, and total cost of
     * items.
     *
     * @return a string representation of the SmartBin.
     */
    @Override
    public String showDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Bin Number: ").append(binNumber).append("\n");
        details.append("Label: ").append(label).append("\n");
        details.append("Current Weight: ").append(getWeight()).append("\n");
        details.append("Total Cost of Items: ").append(calculatePrice().toString()).append("\n");
        return details.toString();
    }
}