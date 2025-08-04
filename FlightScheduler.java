
import java.util.*;

class Flight {
    String destination;
    int duration; // in minutes

    public Flight(String destination, int duration) {
        this.destination = destination;
        this.duration = duration;
    }
}

class FlightScheduler {

    private Map<String, List<Flight>> flightGraph = new HashMap<>();

    public void addFlight(String from, String to, int duration) {
        flightGraph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Flight(to, duration));
    }

    public void findShortestRoute(String start, String end) {
        Map<String, Integer> travelTime = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(travelTime::get));

        for (String city : flightGraph.keySet()) {
            travelTime.put(city, Integer.MAX_VALUE);
        }

        travelTime.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String currentCity = queue.poll();
            for (Flight flight : flightGraph.getOrDefault(currentCity, new ArrayList<>())) {
                int newTime = travelTime.get(currentCity) + flight.duration;
                if (newTime < travelTime.getOrDefault(flight.destination, Integer.MAX_VALUE)) {
                    travelTime.put(flight.destination, newTime);
                    previous.put(flight.destination, currentCity);
                    queue.add(flight.destination);
                }
            }
        }

        if (!travelTime.containsKey(end) || travelTime.get(end) == Integer.MAX_VALUE) {
            System.out.println("No available route from " + start + " to " + end);
            return;
        }

        List<String> path = new LinkedList<>();
        for (String at = end; at != null; at = previous.get(at)) {
            path.add(0, at);
        }

        System.out.println("Shortest route from " + start + " to " + end + ": " + String.join(" -> ", path));
        System.out.println("Total travel time: " + travelTime.get(end) + " minutes");
    }

    public static void main(String[] args) {
        FlightScheduler scheduler = new FlightScheduler();

        scheduler.addFlight("Tampa", "Atlanta", 90);
        scheduler.addFlight("Tampa", "Miami", 60);
        scheduler.addFlight("Miami", "Atlanta", 100);
        scheduler.addFlight("Atlanta", "New York", 150);
        scheduler.addFlight("Miami", "New York", 180);
        scheduler.addFlight("Tampa", "New York", 240);

        scheduler.findShortestRoute("Tampa", "New York");
    }
}
