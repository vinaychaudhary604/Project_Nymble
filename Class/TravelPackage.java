import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity, List<Destination> itinerary) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = itinerary;
        this.passengers = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
            System.out.println("Passenger " + passenger.getName() + " added to the travel package.");
        } else {
            System.out.println("Passenger capacity reached. Cannot add more passengers.");
        }
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        System.out.println("Itinerary:");

        for (Destination destination : itinerary) {
            System.out.println("  Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("    Activity: " + activity.getName() +
                        ", Cost: " + activity.getCost() +
                        ", Capacity: " + activity.getCapacity() +
                        ", Description: " + activity.getDescription());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger List:");
        System.out.println("  Capacity: " + passengerCapacity);
        System.out.println("  Number of passengers enrolled: " + passengers.size());

        for (Passenger passenger : passengers) {
            System.out.println("    Passenger: " + passenger.getName() +
                    ", Number: " + passenger.getNumber());
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities in " + name + ":");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                int spacesAvailable = activity.getCapacity() - activity.getSignedUpPassengers().size();
                System.out.println("  - Activity: " + activity.getName() +
                        ", Destination: " + destination.getName() +
                        ", Spaces Available: " + spacesAvailable);
            }
        }
    }
}
