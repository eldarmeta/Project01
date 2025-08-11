import java.util.Arrays;

/**
 * Helper for tracking counts of required characters and how many are still missing.
 * Works on ASCII by default (size 128). For full Unicode, replace arrays with HashMap<Character,Integer>.
 */
class WindowCounter {
    private final int[] need = new int[128];
    private final int[] have = new int[128];
    private int missing; // total number of characters still needed

    WindowCounter(String t) {
        Arrays.fill(need, 0);
        Arrays.fill(have, 0);
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c < 128) {
                need[c]++;
                missing++;
            } else {
                throw new IllegalArgumentException("Only ASCII supported in this helper. Use HashMap for Unicode.");
            }
        }
    }

    void add(char c) {
        if (c >= 128) return;
        if (need[c] == 0) return;      // not required
        have[c]++;
        if (have[c] <= need[c]) {
            missing--;
        }
    }

    void remove(char c) {
        if (c >= 128) return;
        if (need[c] == 0) return;
        if (have[c] <= need[c]) {
            missing++;
        }
        have[c]--;
    }

    boolean coversAll() {
        return missing == 0;
    }
}
