package unwalla.assign1.salebin;

import unwalla.assign1.money.USMoney;

/**
 * An interface representing an item that is sold.
 */
public interface ItemType {
    /**
     * Returns whether the item is fragile.
     *
     * @return true if the item is fragile, false otherwise
     */
    public boolean isFragile();

    /**
     * Returns the price of the item.
     *
     * @return the price of the item
     */
    public USMoney getPrice();

    /**
     * Returns the weight of the item.
     *
     * @return the weight of the item
     */
    public double getWeight();

    /**
     * Returns a string representation of the item details.
     *
     * @return the item details
     */
    public String getDetails();
}