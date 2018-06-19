import java.util.Random;


public class Jar {
    private String itemName;
    private int maxAmount;
    private int amount;

    public Jar(String itemName, int maxAmount) {
        this.itemName = itemName;
        this.maxAmount = maxAmount;
        fill();
    }

    private void fill() {
        Random random = new Random();
        amount = random.nextInt(maxAmount) + 1;
    }

    public String getItemName() {
        return itemName;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public int getAmount() { return amount; }

    // Utility methods
    public boolean hasFewerThan(int amount) {
        return this.amount < amount;
    }

    public boolean hasMoreThan(int amount) {
        return this.amount > amount;
    }
}
