
/**
 * RoadsideAssistanceSystem.java
 *
 * A basic Java program that simulates a roadside assistance service request system.
 * Users can request help for various car issues like flat tire, battery, fuel, etc.
 *
 * Author: Eldar Abdivaitov
 * Date: 2025-07-17
 */

import java.util.*;

public class RoadsideAssistanceSystem {

    static class AssistanceRequest {
        String customerName;
        String location;
        String issue;
        String vehicle;

        AssistanceRequest(String customerName, String location, String issue, String vehicle) {
            this.customerName = customerName;
            this.location = location;
            this.issue = issue;
            this.vehicle = vehicle;
        }

        @Override
        public String toString() {
            return "Request from " + customerName + " at " + location + " with issue: "" + issue + "" (Vehicle: " + vehicle + ")";
        }
    }

    private static final List<AssistanceRequest> requestLog = new ArrayList<>();

    public static void submitRequest(String name, String location, String issue, String vehicle) {
        AssistanceRequest request = new AssistanceRequest(name, location, issue, vehicle);
        requestLog.add(request);
        System.out.println("✅ Assistance request submitted successfully!");
        System.out.println(request);
    }

    public static void listAllRequests() {
        System.out.println("\n📋 Current Assistance Requests:");
        for (int i = 0; i < requestLog.size(); i++) {
            System.out.println((i + 1) + ". " + requestLog.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🚗 Welcome to the Roadside Assistance System");

        while (true) {
            System.out.println("\n1. Submit a request");
            System.out.println("2. View all requests");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter your location: ");
                    String location = scanner.nextLine();

                    System.out.print("Describe the issue (e.g., Flat tire, Battery dead, Out of gas): ");
                    String issue = scanner.nextLine();

                    System.out.print("Enter your vehicle info (make/model/year): ");
                    String vehicle = scanner.nextLine();

                    submitRequest(name, location, issue, vehicle);
                    break;

                case 2:
                    listAllRequests();
                    break;

                case 3:
                    System.out.println("👋 Goodbye!");
                    return;

                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }
    }
}
