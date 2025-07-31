
import java.util.*;

public class TaxiDispatchSimulator {

    static class Location {
        int x, y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distanceTo(Location other) {
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y); // Manhattan Distance
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    static class Client {
        String name;
        Location location;

        public Client(String name, Location location) {
            this.name = name;
            this.location = location;
        }
    }

    static class Taxi {
        String id;
        Location currentLocation;
        boolean isAvailable;

        public Taxi(String id, Location currentLocation) {
            this.id = id;
            this.currentLocation = currentLocation;
            this.isAvailable = true;
        }

        public void assignClient(Client client) {
            System.out.println("🚖 Taxi " + id + " assigned to " + client.name + " at " + client.location);
            this.currentLocation = client.location;
            this.isAvailable = false;

            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
            System.out.println("✅ Taxi " + id + " picked up " + client.name + "!");
            this.isAvailable = true;
        }
    }

    public static void main(String[] args) {
        List<Taxi> taxis = Arrays.asList(
                new Taxi("T1", new Location(0, 0)),
                new Taxi("T2", new Location(5, 5)),
                new Taxi("T3", new Location(10, 2))
        );

        List<Client> clients = Arrays.asList(
                new Client("Alice", new Location(3, 2)),
                new Client("Bob", new Location(6, 6)),
                new Client("Charlie", new Location(8, 1))
        );

        for (Client client : clients) {
            Taxi nearestTaxi = findNearestTaxi(client, taxis);
            if (nearestTaxi != null) {
                nearestTaxi.assignClient(client);
            } else {
                System.out.println("❌ No available taxis for " + client.name);
            }
        }
    }

    private static Taxi findNearestTaxi(Client client, List<Taxi> taxis) {
        Taxi nearest = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {
            if (taxi.isAvailable) {
                int distance = taxi.currentLocation.distanceTo(client.location);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearest = taxi;
                }
            }
        }
        return nearest;
    }
}
