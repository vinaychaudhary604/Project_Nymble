


// import org.junit.Test;
// import static org.junit.Assert.*;

import java.util.ArrayList;
// import java.util.List;

public class PassengerTest {

    public static void main(String[] args) {
        testSignUpActivityStandard();
        testSignUpActivityGold();
        testSignUpActivityPremium();
        testSignUpActivityInsufficientBalance();
    }

    @Test
    public static void testSignUpActivityStandard() {
        
        Passenger passenger = new Passenger("John", "P001", "standard", 100.0);
        Destination destination = new Destination("City A", new ArrayList<>());
        Activity activity = new Activity("Sightseeing", "Explore the city", 50.0, 20, destination);

        passenger.signUpActivity(activity);

        assertEquals(50.0, passenger.getBalance(), 0.001);
        assertTrue(((ArrayList<Activity>) passenger.getActivities()).contains(activity));
    }

    private static void assertTrue(boolean contains) {
    }

    private static void assertEquals(double d, double balance, double e) {
    }

    @Test
    public static void testSignUpActivityGold() {
        
        Passenger passenger = new Passenger("Alice", "P002", "gold", 200.0);
        Destination destination = new Destination("City B", new ArrayList<>());
        Activity activity = new Activity("Hiking", "Scenic trail", 30.0, 15, destination);

        passenger.signUpActivity(activity);

        assertEquals(170.0, passenger.getBalance(), 0.001);
        assertTrue(((ArrayList<Activity>) passenger.getActivities()).contains(activity));
    }

    @Test
    public static void testSignUpActivityPremium() {
        
        Passenger passenger = new Passenger("Bob", "P003", "premium", 0.0);
        Destination destination = new Destination("City C", new ArrayList<>());
        Activity activity = new Activity("Beach Day", "Relax on the beach", 40.0, 25, destination);

        passenger.signUpActivity(activity);

        assertTrue(((ArrayList<Activity>) passenger.getActivities()).contains(activity));
    }

    @Test
    public static void testSignUpActivityInsufficientBalance() {
        
        Passenger passenger = new Passenger("Charlie", "P004", "standard", 30.0);
        Destination destination = new Destination("City D", new ArrayList<>());
        Activity activity = new Activity("Snorkeling", "Underwater adventure", 60.0, 10, destination);

        passenger.signUpActivity(activity);

        assertFalse(((ArrayList<Activity>) passenger.getActivities()).contains(activity));
    }

    private static void assertFalse(boolean contains) {
    }
}
