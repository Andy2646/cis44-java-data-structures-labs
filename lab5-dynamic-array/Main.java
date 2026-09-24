public class Main {
    public static void main(String[] args) {
        // Create inventory
        Inventory inventory = new Inventory();
        System.out.println("Create new inventory");

        // Add items to inventory
        System.out.println("Adding 6 items to inventory");
        inventory.addItem(new Item("Apple"));
        inventory.addItem(new Item("Gold"));
        inventory.addItem(new Item("Iron"));
        inventory.addItem(new Item("Diamond"));
        inventory.addItem(new Item("Sword"));
        inventory.addItem(new Item("Axe"));
        inventory.display();

        // Crafting items to inventory
        System.out.println("Crafting 'Diamond' and 'Sword'");
        inventory.combineItems("Diamond", "Sword");
        inventory.display();

        System.out.println("Crafting 'Iron' and 'Axe'");
        inventory.combineItems("Iron", "Axe");
        inventory.display();

        System.out.println("Crafting 'Gold' and 'Axe'"); // Axe is not in inventory after the second combination
        inventory.combineItems("Gold", "Axe");
        inventory.display();
    }
}
