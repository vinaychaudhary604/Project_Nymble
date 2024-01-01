import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private List<Passenger> signedUpPassengers;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.signedUpPassengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public Destination getDestination() {
        return destination;
    }

    public boolean signUpPassenger(Passenger passenger) {
        if (signedUpPassengers.size() < capacity) {
            signedUpPassengers.add(passenger);
            System.out.println("Passenger " + passenger.getName() + " signed up for the activity " + name);
            return true;
        } else {
            System.out.println("Activity " + name + " has reached its capacity. Cannot sign up more passengers.");
            return false;
        }
    }

    public List<Passenger> getSignedUpPassengers() {
        return signedUpPassengers;
    }

    public int getSpacesAvailable() {
        return capacity - signedUpPassengers.size();
    }

    public String getDescription() {
        return description;
    }
}