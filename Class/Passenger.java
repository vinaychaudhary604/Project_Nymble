import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private String number;
    private String type;
    private double balance;
    private List<Activity> activities;

    public Passenger(String name, String number, String type, double balance) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void signUpActivity(Activity activity) {
        if (activity.signUpPassenger(this)) {
            if (type.equals("standard")) {
                if (balance >= activity.getCost()) {
                    balance -= activity.getCost();
                    activities.add(activity);
                } else {
                    System.out.println("Insufficient balance. Cannot sign up for the activity.");
                }
            } else if (type.equals("gold")) {
                double discountedCost = 0.9 * activity.getCost();
                if (balance >= discountedCost) {
                    balance -= discountedCost;
                    activities.add(activity);
                } else {
                    System.out.println("Insufficient balance. Cannot sign up for the activity.");
                }
            } else if (type.equals("premium")) {
                activities.add(activity);
            }
        }
    }

    public void printDetails() {
        System.out.println("Passenger: " + name + " (" + number + ")");
        System.out.println("Balance: " + balance);
        System.out.println("Activities signed up for:");
        for (Activity activity : activities) {
            System.out.println("  Activity: " + activity.getName() +
                    ", Destination: " + activity.getDestination().getName() +
                    ", Price: " + activity.getCost());
        }
    }
}
