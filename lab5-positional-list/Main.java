import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Create a linked positional list
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        // Adding Stops
        Position<String> stop1 = itinerary.addFirst("El Camino Real");
        System.out.println("Added '"+stop1.getElement()+"' in first");
        Position<String> stop2 = itinerary.addFirst("El Sobrante");
        System.out.println("Added '"+stop2.getElement()+"' in first");
        Position<String> stop3 = itinerary.addLast("Mission College");
        System.out.println("Added '"+stop3.getElement()+"' in last");
        Position<String> stop4 = itinerary.addFirst("Benton");
        System.out.println("Added '"+stop4.getElement()+"' in first");
        Position<String> stop5 = itinerary.addAfter(stop2, "Cabrillo");
        System.out.println("Added '"+stop5.getElement()+"' after '"+stop2.getElement()+"'");
        Position<String> stop6 = itinerary.addBefore(stop3, "Central");
        System.out.println("Added '"+stop6.getElement()+"' before '"+stop3.getElement()+"'");

        // Configuring Stops
        String oldStop = itinerary.set(stop1, "Warburton");
        System.out.println("Switch '" + oldStop + "' to 'Warburton'");
        String removedStop = itinerary.remove(stop2);
        System.out.println("Removed '" + removedStop + "'");
        System.out.println();

        // Iterator
        Iterator<String> iterator = itinerary.iterator();

        System.out.println("Travel Itinerary:");
        for (String currentStop : itinerary) {
            currentStop = iterator.next();

            System.out.println(currentStop);
        }
    }
}
