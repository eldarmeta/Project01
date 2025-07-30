import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BitcoinPriceTracker {

    private static final String API_URL = "https://api.coindesk.com/v1/bpi/currentprice/BTC.json";
    private static final List<Double> priceHistory = new ArrayList<>();
    private static final List<LocalDateTime> timeHistory = new ArrayList<>();
    private static final int REFRESH_INTERVAL_MS = 10_000; // 10 seconds
    private static final int HISTORY_LIMIT = 60; // roughly 10 minutes of history

    public static void main(String[] args) {
        Timer timer = new Timer();
        System.out.println("🚀 Bitcoin Price Tracker Started...\n");

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                double price = fetchBitcoinPrice();
                if (price > 0) {
                    addToHistory(price);
                    displayStats();
                }
            }
        }, 0, REFRESH_INTERVAL_MS);
    }

    private static double fetchBitcoinPrice() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(API_URL).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null)
                response.append(line);

            reader.close();

            JSONObject json = new JSONObject(response.toString());
            return json.getJSONObject("bpi").getJSONObject("USD").getDouble("rate_float");

        } catch (Exception e) {
            System.out.println("❌ Failed to fetch price: " + e.getMessage());
            return -1;
        }
    }

    private static void addToHistory(double price) {
        if (priceHistory.size() >= HISTORY_LIMIT) {
            priceHistory.remove(0);
            timeHistory.remove(0);
        }
        priceHistory.add(price);
        timeHistory.add(LocalDateTime.now());
    }

    private static void displayStats() {
        double current = priceHistory.get(priceHistory.size() - 1);
        double min = priceHistory.stream().min(Double::compare).orElse(current);
        double max = priceHistory.stream().max(Double::compare).orElse(current);
        double avg = priceHistory.stream().mapToDouble(Double::doubleValue).average().orElse(current);
        double change = current - priceHistory.get(0);

        System.out.println("🕒 " + LocalDateTime.now());
        System.out.printf("💰 Current: $%.2f | 📉 Min: $%.2f | 📈 Max: $%.2f | 📊 Avg: $%.2f%n", current, min, max, avg);
        System.out.printf("📈 Change (%.1f min): $%.2f\n", priceHistory.size() * (REFRESH_INTERVAL_MS / 60000.0), change);
        System.out.println("------------------------------------------------------");
    }
}