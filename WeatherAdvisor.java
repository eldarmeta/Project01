
import java.util.Scanner;

public class WeatherAdvisor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Weather Advisor ===");
        System.out.print("Enter current temperature (°F): ");
        int temperature = scanner.nextInt();

        System.out.print("Enter humidity percentage (%): ");
        int humidity = scanner.nextInt();

        System.out.println("\nAnalyzing weather conditions...\n");

        giveAdvice(temperature, humidity);

        scanner.close();
    }

    public static void giveAdvice(int temp, int humidity) {
        if (temp > 90) {
            System.out.println("🔥 It's hot outside. Stay hydrated!");
        } else if (temp >= 70 && temp <= 90) {
            System.out.println("🌤️ Great weather! Go for a walk.");
        } else if (temp >= 50 && temp < 70) {
            System.out.println("🧥 Might be a bit chilly. Bring a jacket.");
        } else {
            System.out.println("❄️ It's cold! Wear warm clothes.");
        }

        if (humidity > 80) {
            System.out.println("💧 High humidity detected. It might feel hotter than it is.");
        } else if (humidity < 30) {
            System.out.println("🌵 Air is dry. Use moisturizer or a humidifier.");
        } else {
            System.out.println("✅ Humidity is in a comfortable range.");
        }
    }
}
