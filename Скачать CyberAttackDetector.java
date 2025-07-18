
/**
 * CyberAttackDetector.java
 *
 * A simple Java program simulating basic intrusion detection by scanning network requests
 * for potential cyber attack keywords (e.g., SQL injections, admin access, etc.).
 *
 * This project is intended for educational purposes only and demonstrates how pattern
 * matching can help identify malicious traffic in a simulated environment.
 *
 * Author: Eldar Abdivaitov
 * Date: 2025-07-17
 */

import java.util.*;
import java.time.LocalDateTime;

public class CyberAttackDetector {

    // List of suspicious keywords representing potential threats
    private static final Set<String> BLACKLIST = Set.of(
        "DROP", "DELETE", "SELECT", "INSERT", "admin", "password", "shutdown", "root"
    );

    /**
     * Checks if the request contains any blacklisted keyword.
     *
     * @param request the incoming request string
     * @return true if malicious pattern is detected, false otherwise
     */
    public static boolean isMalicious(String request) {
        for (String keyword : BLACKLIST) {
            if (request.toUpperCase().contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Scans incoming network requests for suspicious patterns.
     *
     * @param trafficLogs the list of simulated network requests
     */
    public static void scanTraffic(List<String> trafficLogs) {
        int alertCount = 0;
        System.out.println("🔍 Starting network traffic scan at " + LocalDateTime.now() + "\n");

        for (int i = 0; i < trafficLogs.size(); i++) {
            String request = trafficLogs.get(i);
            if (isMalicious(request)) {
                alertCount++;
                System.out.println("⚠️ [ALERT] Suspicious activity in request #" + (i + 1) + ": " + request);
            } else {
                System.out.println("✅ Request #" + (i + 1) + " is clean.");
            }
        }

        System.out.println("\n=== SCAN COMPLETE ===");
        if (alertCount == 0) {
            System.out.println("✅ No threats detected.");
        } else {
            System.out.println("🚨 Total suspicious requests: " + alertCount);
        }
    }

    public static void main(String[] args) {
        List<String> incomingTraffic = List.of(
            "GET /home",
            "POST /login username=admin&password=1234",
            "SELECT * FROM users WHERE name='hacker'",
            "GET /about",
            "DELETE FROM users WHERE id=5",
            "GET /api/shutdown"
        );

        scanTraffic(incomingTraffic);
    }
}
