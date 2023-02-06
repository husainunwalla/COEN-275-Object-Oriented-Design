package unwalla.assign1.salebin;

import unwalla.assign1.money.USMoney;

public class SaleItem implements ItemType {
    private String itemName;
    private USMoney price;
    private double weight;
    private boolean fragile;

    /**
     * Creates a new SaleItem object.
     *
     * @param itemName the name of the item
     * @param price the price of the item
     * @param weight the weight of the item
     * @param fragile true if the item is fragile, false otherwise
     */
    public SaleItem(String itemName, USMoney price, double weight, boolean fragile) {
        this.itemName = itemName;
        this.price = price;
        this.weight = weight;
        this.fragile = fragile;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isFragile() {
        return fragile;
    }

    /**
     * {@inheritDoc}
     */
    public USMoney getPrice() {
        return price;
    }

    /**
     * {@inheritDoc}
     */
    public double getWeight() {
        return weight;
    }

    /**
     * {@inheritDoc}
     */
    public String getDetails() {
        return itemName + price;
    }
}