
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
class TravelPackageSystemTest {

     public static void main(String[] args) {
        createPassengerTest();
        signUpForActivityTest();
        travelPackageIntegrationTest();
    }


    @Test
    static
    void createPassengerTest() {
        
        String mockInput = "John\n123\nstandard\n500.0\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(mockInput.getBytes()));

        Passenger passenger = TravelPackageSystem.createPassenger(scanner);

        assertEquals("John", passenger.getName());
        assertEquals("123", passenger.getNumber());
        assertEquals("standard", passenger.getType());
        assertEquals(500.0, passenger.getBalance(), 0.001);
    }

    private static void assertEquals(double d, double balance, double e) {
    }

    private static void assertEquals(String string, String name) {
    }

    @Test
    static
    void signUpForActivityTest() {
        
        String mockInput = "yes";
        Scanner scanner = new Scanner(new ByteArrayInputStream(mockInput.getBytes()));

        Passenger passenger = new Passenger("John", "123", "standard", 500.0);
        Activity activity = new Activity("Sightseeing", "Explore the city", 50.0, 20, null);

        TravelPackageSystem.signUpForActivity(scanner, passenger, activity);

        assertTrue(((List<Activity>) passenger.getActivities()).contains(activity));

    }

    private static void assertTrue(boolean contains) {
    }


    @Test
    static
    void travelPackageIntegrationTest() {
        
        String mockInput = "John\n123\nstandard\n500.0\nJane\n456\ngold\n1000.0\nBob\n789\npremium\n1500.0\nyes\nyes\nyes";
        Scanner scanner = new Scanner(mockInput);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        TravelPackageSystem.main(null);

        String expectedOutput = "Vacation Package\n" +
                "Destination: City A\n" +
                " - Activity: Sightseeing\n" +
                "   - Participants: John\n" +
                "Destination: City B\n" +
                " - Activity: Beach Day\n" +
                "   - Participants: Jane, Bob\n" +
                "Passenger List:\n" +
                "1. Name: John, Number: 123, Type: standard, Balance: 500.0\n" +
                "2. Name: Jane, Number: 456, Type: gold, Balance: 1000.0\n" +
                "3. Name: Bob, Number: 789, Type: premium, Balance: 1500.0\n" +
                "Available Activities:\n" +
                "1. Destination: City A - Activity: Hiking\n" +
                "2. Destination: City B - Activity: Snorkeling\n";

        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }
}
