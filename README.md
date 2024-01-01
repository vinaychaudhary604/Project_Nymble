# Travel Package System

The Travel Package System is a Java application that simulates a travel package management system. It allows users to create travel packages, add passengers, sign up passengers for activities, and view package details.

## Features

- **TravelPackage Class:** Represents a travel package with a name, passenger capacity, itinerary, and list of enrolled passengers.

- **Destination Class:** Represents a destination with a name and a list of activities.

- **Activity Class:** Represents an activity with a name, description, cost, capacity, destination, and a list of signed-up passengers.

- **Passenger Class:** Represents a passenger with a name, number, type (standard/gold/premium), balance, and a list of signed-up activities.

- **TravelPackageSystem Class:** Contains the `main` method for running the application. It creates destinations, activities, a travel package, and allows users to interactively add passengers and sign them up for activities.

## How to Run

1. Compile the Java files:

    ```bash
    javac *.java
    ```

2. Run the TravelPackageSystem:

    ```bash
    java TravelPackageSystem
    ```

3. Follow the on-screen instructions to add passengers and sign them up for activities.

## Example

```java
// Example usage in TravelPackageSystem

// Create a travel package
TravelPackage travelPackage = new TravelPackage("Vacation Package", 30, itinerary);

// Create passengers
Passenger passenger1 = new Passenger("John Doe", "P001", "standard", 100.0);
Passenger passenger2 = new Passenger("Alice Smith", "P002", "gold", 200.0);
Passenger passenger3 = new Passenger("Bob Johnson", "P003", "premium", 0.0);

// Add passengers to the travel package
travelPackage.addPassenger(passenger1);
travelPackage.addPassenger(passenger2);
travelPackage.addPassenger(passenger3);

// Sign up passengers for activities
passenger1.signUpActivity(activity1);
passenger2.signUpActivity(activity2);
passenger3.signUpActivity(activity3);

// Print travel package details
travelPackage.printItinerary();
travelPackage.printPassengerList();
travelPackage.printAvailableActivities();


