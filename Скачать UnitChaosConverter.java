import java.util.*;

public class UnitChaosConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🌎 Welcome to UnitChaos Converter 🇺🇸 ➡ 🌍");
        System.out.println("Choose conversion type:");
        System.out.println("1. Fahrenheit → Celsius");
        System.out.println("2. Gallons → Liters");
        System.out.println("3. Ounces → Milliliters");
        System.out.println("4. Pounds → Kilograms");
        System.out.println("5. Miles → Kilometers");
        System.out.println("6. Inches → Centimeters");
        System.out.print("Enter choice (1-6): ");

        int choice = scanner.nextInt();
        System.out.print("Enter value: ");
        double value = scanner.nextDouble();

        double result = switch (choice) {
            case 1 -> (value - 32) * 5 / 9;
            case 2 -> value * 3.78541;
            case 3 -> value * 29.5735;
            case 4 -> value * 0.453592;
            case 5 -> value * 1.60934;
            case 6 -> value * 2.54;
            default -> {
                System.out.println("🤡 Invalid choice. You just got lost in imperial hell.");
                yield -1;
            }
        };

        if (result != -1) {
            System.out.println("✅ Converted value: " + result);
        }
    }
}
