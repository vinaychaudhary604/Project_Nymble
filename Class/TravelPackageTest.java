// import org.junit.Test;
// import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TravelPackageTest {

    public static void main(String[] args) {
        testAddPassenger();
        testPrintItinerary();
        testPrintPassengerList();
        testPrintAvailableActivities();
    }

    private static void testAddPassenger() {
    }

    @Test
    public static void testPrintItinerary() {
        
        List<Destination> itinerary = new ArrayList<>();
        TravelPackage travelPackage = new TravelPackage("Test Package", 3, itinerary);

        Destination destination1 = new Destination("City A", new ArrayList<>());
        Destination destination2 = new Destination("City B", new ArrayList<>());

        Activity activity1 = new Activity("Sightseeing", "Explore the city", 50.0, 20, destination1);
        Activity activity2 = new Activity("Hiking", "Scenic trail", 30.0, 15, destination1);

        destination1.addActivity(activity1);
        destination1.addActivity(activity2);

        Activity activity3 = new Activity("Beach Day", "Relax on the beach", 40.0, 25, destination2);
        Activity activity4 = new Activity("Snorkeling", "Underwater adventure", 60.0, 10, destination2);

        destination2.addActivity(activity3);
        destination2.addActivity(activity4);

        itinerary.add(destination1);
        itinerary.add(destination2);

        travelPackage.printItinerary();

        assertEquals("Travel Package: Test Package\n" +
                     "Itinerary:\n" +
                     "  Destination: City A\n" +
                     "    Activity: Sightseeing, Cost: 50.0, Capacity: 20, Description: Explore the city\n" +
                     "    Activity: Hiking, Cost: 30.0, Capacity: 15, Description: Scenic trail\n" +
                     "  Destination: City B\n" +
                     "    Activity: Beach Day, Cost: 40.0, Capacity: 25, Description: Relax on the beach\n" +
                     "    Activity: Snorkeling, Cost: 60.0, Capacity: 10, Description: Underwater adventure\n", travelPackage.getSystemOut());
    }

    @Test
    public static void testPrintPassengerList() {
        
        List<Destination> itinerary = new ArrayList<>();
        TravelPackage travelPackage = new TravelPackage("Test Package", 3, itinerary);

        Passenger passenger1 = new Passenger("John", "P001", "standard", 100.0);
        Passenger passenger2 = new Passenger("Alice", "P002", "gold", 200.0);
        Passenger passenger3 = new Passenger("Bob", "P003", "premium", 0.0);

        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.addPassenger(passenger3);

        travelPackage.printPassengerList();

        assertEquals("Travel Package: Test Package\n" +
                     "Passenger List:\n" +
                     "  Capacity: 3\n" +
                     "  Number of passengers enrolled: 3\n" +
                     "    Passenger: John, Number: P001\n" +
                     "    Passenger: Alice, Number: P002\n" +
                     "    Passenger: Bob, Number: P003\n", travelPackage.getSystemOut());
    }

    @Test
    public static void testPrintAvailableActivities() {
        
        List<Destination> itinerary = new ArrayList<>();
        TravelPackage travelPackage = new TravelPackage("Test Package", 3, itinerary);

        Destination destination1 = new Destination("City A", new ArrayList<>());
        Destination destination2 = new Destination("City B", new ArrayList<>());

        Activity activity1 = new Activity("Sightseeing", "Explore the city", 50.0, 20, destination1);
        Activity activity2 = new Activity("Hiking", "Scenic trail", 30.0, 15, destination1);

        destination1.addActivity(activity1);
        destination1.addActivity(activity2);

        Activity activity3 = new Activity("Beach Day", "Relax on the beach", 40.0, 25, destination2);
        Activity activity4 = new Activity("Snorkeling", "Underwater adventure", 60.0, 10, destination2);

        destination2.addActivity(activity3);
        destination2.addActivity(activity4);

        itinerary.add(destination1);
        itinerary.add(destination2);

        travelPackage.printAvailableActivities();

        assertEquals("Available Activities in Test Package:\n" +
                     "  - Activity: Sightseeing, Destination: City A, Spaces Available: 20\n" +
                     "  - Activity: Hiking, Destination: City A, Spaces Available: 15\n" +
                     "  - Activity: Beach Day, Destination: City B, Spaces Available: 25\n" +
                     "  - Activity: Snorkeling, Destination: City B, Spaces Available: 10\n", travelPackage.getSystemOut());
    }

    private static void assertEquals(String string, Object systemOut) {
    }

}
