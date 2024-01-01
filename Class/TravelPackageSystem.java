// import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelPackageSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Activity> activities1 = List.of(new Activity("Sightseeing", "Explore the city", 50.0, 20, null),
                new Activity("Hiking", "Scenic trail", 30.0, 15, null));

        List<Activity> activities2 = List.of(new Activity("Beach Day", "Relax on the beach", 40.0, 25, null),
                new Activity("Snorkeling", "Underwater adventure", 60.0, 10, null));

        Destination destination1 = new Destination("City A", activities1);
        Destination destination2 = new Destination("City B", activities2);

        List<Destination> itinerary = List.of(destination1, destination2);
        TravelPackage travelPackage = new TravelPackage("Vacation Package", 30, itinerary);

        System.out.println("Enter passenger details:");

        Passenger passenger1 = createPassenger(scanner);
        Passenger passenger2 = createPassenger(scanner);
        Passenger passenger3 = createPassenger(scanner);

        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.addPassenger(passenger3);

        signUpForActivity(scanner, passenger1, activities1.get(0));
        signUpForActivity(scanner, passenger2, activities2.get(1));
        signUpForActivity(scanner, passenger3, activities2.get(0));

        travelPackage.printItinerary();
        travelPackage.printPassengerList();
        travelPackage.printAvailableActivities();

        scanner.close();
    }

    static Passenger createPassenger(Scanner scanner) {
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        System.out.print("Enter passenger number: ");
        String number = scanner.nextLine();
        System.out.print("Enter passenger type (standard/gold/premium): ");
        String type = scanner.nextLine();
        System.out.print("Enter passenger balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); 

        return new Passenger(name, number, type, balance);
    }

    static void signUpForActivity(Scanner scanner, Passenger passenger, Activity activity) {
        System.out.println("Sign up " + passenger.getName() + " for the activity " + activity.getName() + "? (yes/no)");
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("yes")) {
            passenger.signUpActivity(activity);
        }
    }
}
