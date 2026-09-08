import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Create a dynamic array
        DynamicArray<Integer> array = new DynamicArray<Integer>();
        Random random = new Random();

        System.out.println("Creating empty array:");
        System.out.println("Size: " + array.size());
        array.displayArray();

        // Adding elements into array
        for (int i = 1; i <= 5; i++) {
            array.add(random.nextInt(11));
        }

        System.out.println("\nAdding 5 elements into an array:");
        System.out.println("Size: " + array.size());
        array.displayArray();

        // Adding an element into a full array
        array.add(random.nextInt(11));

        System.out.println("\nAdding element into an array that is full:");
        System.out.println("Size: " + array.size());
        array.displayArray();

        //Finding an element at a specific index
        try {
            System.out.println("\nFinding element at index 2: ");
            System.out.println(array.get(2));

            System.out.println("\nFinding element at index 8: "); // nothing in the array
            System.out.println(array.get(8));
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        try {
            System.out.println("\nFinding element at index 10: "); // nothing outside the array
            System.out.println(array.get(10));
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        //Filling up the array
        for (int i = 1; i <= 4; i++) {
            array.add(random.nextInt(11));
        }

        System.out.println("\nAdding 4 more elements into an array:");
        System.out.println("Size: " + array.size());
        array.displayArray();

        //Removing an element at a specific index
        try {
            System.out.println("\nRemoving element at index 9: ");
            System.out.println("Removed " + array.remove(9) + " from array"); // end of the array
            System.out.println("Size: " + array.size());
            array.displayArray();

            System.out.println("\nRemoving element at index 4: ");
            System.out.println("Removed " + array.remove(4) + " from array"); // middle of the array
            System.out.println("Size: " + array.size());
            array.displayArray();

            System.out.println("\nRemoving element at index 0: ");
            System.out.println("Removed " + array.remove(0) + " from array"); // start of the array
            System.out.println("Size: " + array.size());
            array.displayArray();

            System.out.println("\nRemoving element at index 8: ");
            System.out.println("Removed " + array.remove(8) + " from array"); // nothing inside the array
            System.out.println("Size: " + array.size());
            array.displayArray();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        try {
            System.out.println("\nRemoving element at index 10: ");
            System.out.println("Removed " + array.remove(10) + " from array"); // nothing outside the array
            System.out.println("Size: " + array.size());
            array.displayArray();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // Creating new array
        DynamicArray<String> words = new DynamicArray<String>();

        System.out.println("\nCreating new empty array:");
        System.out.println("Size: " + words.size());
        words.displayArray();

        // Adding elements
        words.add("Hello");
        words.add("Banana");
        words.add("People");
        words.add("Thanks for");
        words.add("watching!");

        System.out.println("\nAdding 5 elements to new array:");
        System.out.println("Size: " + words.size());
        words.displayArray();
    }
}
