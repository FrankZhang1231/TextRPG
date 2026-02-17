package player;

public class InventoryItems {
    private Weapons weapon;
    private int quantity;

    public InventoryItems(Weapons weapon) {
        this.weapon = weapon;
        this.quantity = 1;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    public void deleteItem(int amount) {
        this.quantity -= amount;
    }
}
