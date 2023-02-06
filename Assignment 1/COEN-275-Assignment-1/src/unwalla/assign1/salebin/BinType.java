package unwalla.assign1.salebin;
import unwalla.assign1.money.USMoney;

/**
 * An interface representing a bin for storing items.
 */
public interface BinType {
    /**
     * Adds an item to the bin.
     *
     * @param item the item to be added
     */
    public void addItem(ItemType item);

    /**
     * Calculates the total price of all items in the bin.
     *
     * @return the total price
     */
    public USMoney calculatePrice();

    /**
     * Returns the total weight of all items in the bin.
     *
     * @return the total weight
     */
    public double getWeight();

    /**
     * Returns the number of items in the bin.
     *
     * @return the number of items
     */
    public int getNoOfItems();

    /**
     * Returns a string representation of the bin details.
     *
     * @return the bin details
     */
    public String showDetails();
}



