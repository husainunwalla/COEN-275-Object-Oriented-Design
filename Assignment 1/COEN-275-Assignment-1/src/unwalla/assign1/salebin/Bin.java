package unwalla.assign1.salebin;

import unwalla.assign1.money.USMoney;

import java.util.Arrays;

/**
 * The Bin class implements the BinType interface and represents a basic bin with a bin number and an array of items.
 */

public class Bin implements BinType {
    private static int binCounter = 0;
    protected String binNumber;
    protected ItemType[] items;
    protected final double maxWeight;

    /**
     * Creates a new Bin instance. The bin number will be generated using the generateBinNumber method.
     */
    public Bin() {
        binNumber = "B" + generateBinNumber();
        items = new ItemType[0];
        maxWeight = 100;
    }

    /**
     * Generates a unique number for the bin number by incrementing a class-level counter.
     *
     * @return A unique number for the bin number.
     */
    protected static int generateBinNumber() {
        return ++binCounter;
    }

    /**
     * Adds an item to the bin. The item will only be added if the weight of the item plus the current weight of the bin does not exceed the maxWeight of the bin and if item is not fragile.
     *
     * @param item The item to be added to the bin.
     */
    public void addItem(ItemType item) {
        double currentWeight = getWeight();
        if (currentWeight + item.getWeight() <= maxWeight && !item.isFragile()) {
            ItemType[] newItems = Arrays.copyOf(items, items.length + 1);
            newItems[newItems.length - 1] = item;
            items = newItems;
        }
    }

    /**
     * Calculates the total price of all items in the bin and returns it as a USMoney object.
     *
     * @return The total price of all items in the bin.
     */
    public USMoney calculatePrice() {
        USMoney totalCost = new USMoney(100, 0);
        for (ItemType item : items) {
            totalCost = totalCost.add(item.getPrice());
        }
        return totalCost;
    }

    /**
     * Gets the total weight of the items in the bin
     * @return The total weight of the items in the bin
     */
    public double getWeight() {
        double weight = 0;
        for (int i = 0; i < getNoOfItems(); i++) {
            weight += items[i].getWeight();
        }
        return weight;
    }

    /**
     * Gets the number of items in the bin
     * @return The number of items in the bin
     */
    public int getNoOfItems() {
        int noOfItems = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                noOfItems++;
            } else {
                break;
            }
        }
        return noOfItems;
    }

    public String showDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Bin Number: " + binNumber + "\n");
        details.append("Current Weight: " + getWeight() + "\n");
        details.append("Total Cost of Items: " + calculatePrice().toString());
        return details.toString();
    }
}