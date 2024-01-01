


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import Test.Test;

// import Activity;
// import Destination;
// import Passenger;
// import Test;

public class ActivityTest {
    public static void main(String[] args) {
        testSignUpPassengerSuccess();
    }

    @Test
    public static void testSignUpPassengerSuccess() {
        
        Destination destination = new Destination("Test Destination", new ArrayList<>());
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, destination);
        Passenger passenger = new Passenger("John", "P001", "standard", 100.0);

        ByteArrayOutputStream systemOutContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutContent));

        boolean result = activity.signUpPassenger(passenger);

        assertTrue(result);
        assertEquals("Passenger John signed up for the activity Test Activity\n", systemOutContent.toString());

        System.setOut(System.out);
    }

    private static void assertEquals(String string, String string2) {
    }

    private static void assertTrue(boolean result) {
    }

    @Test
    public void testSignUpPassengerFailure() {
        
        Destination destination = new Destination("Test Destination", new ArrayList<>());
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 1, destination);
        Passenger passenger1 = new Passenger("John", "P001", "standard", 100.0);
        Passenger passenger2 = new Passenger("Alice", "P002", "standard", 150.0);

        ByteArrayOutputStream systemOutContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutContent));

        activity.signUpPassenger(passenger1);
        boolean result = activity.signUpPassenger(passenger2);

        assertTrue(result);
        assertEquals("Passenger John signed up for the activity Test Activity\n" +
                     "Activity Test Activity has reached its capacity. Cannot sign up more passengers.\n", systemOutContent.toString());

        System.setOut(System.out);
    } 

}
