import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void display() {
        System.out.println("Inventory:");
        for (Item currentItem : items) {
            System.out.println(currentItem.getName());
        }
        System.out.println();
    }

    public void combineItems(String name1, String name2) {
        Item item1 = null;
        Item item2 = null;

        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item current = iter.next();
            if (current.getName().equals(name1) || current.getName().equals(name2)) {
                if (item1 == null) {
                    // Check out first item is found in our inventory
                    item1 = current;
                }
                else {
                    // If the first item is checked, check the second item.
                    item2 = current;
                }
            }
        }

        // After the loop, check if both items were found.
        if (item2 != null && item1 != null) {
            items.remove(item1);
            items.remove(item2);
            // If so, create the new crafted item and add it to our inventory
            items.add(new Item(name1 + " " + name2));
        }
        else {
            System.out.println("One of the items you put are not in your inventory");
        }
    }
}
