
import java.util.*;

public class SmartAirMonitor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter indoor humidity (%): ");
        double indoorHumidity = sc.nextDouble();

        System.out.print("Enter outdoor humidity (%): ");
        double outdoorHumidity = sc.nextDouble();

        System.out.print("Enter indoor temperature (°C): ");
        double indoorTemp = sc.nextDouble();

        System.out.print("Enter outdoor temperature (°C): ");
        double outdoorTemp = sc.nextDouble();

        evaluateAirQuality(indoorHumidity, outdoorHumidity, indoorTemp, outdoorTemp);
    }

    public static void evaluateAirQuality(double indoorHumidity, double outdoorHumidity, double indoorTemp, double outdoorTemp) {
        System.out.println("\n🔍 Air Quality Report:");
        System.out.printf("Indoor Humidity: %.1f%%\n", indoorHumidity);
        System.out.printf("Outdoor Humidity: %.1f%%\n", outdoorHumidity);
        System.out.printf("Indoor Temp: %.1f°C\n", indoorTemp);
        System.out.printf("Outdoor Temp: %.1f°C\n", outdoorTemp);

        // Ideal indoor humidity is 30-50%
        if (indoorHumidity < 30) {
            System.out.println("❌ Air too dry. Consider using a humidifier.");
        } else if (indoorHumidity > 50) {
            System.out.println("❌ Air too humid. Risk of mold. Use a dehumidifier.");
        } else {
            System.out.println("✅ Humidity is in the ideal range.");
        }

        // Suggest ventilation or AC
        if (indoorTemp > 26 && outdoorHumidity < indoorHumidity) {
            System.out.println("💡 Suggestion: Open windows or use ventilation.");
        } else if (indoorTemp > 28) {
            System.out.println("💡 Suggestion: Turn on air conditioning.");
        } else if (indoorTemp < 18) {
            System.out.println("💡 Suggestion: Consider heating.");
        } else {
            System.out.println("👌 Temperature is comfortable.");
        }
    }
}
