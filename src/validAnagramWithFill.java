import java.util.Arrays;

public class validAnagramWithFill {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[128]; // ASCII поддержка

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
            freq[t.charAt(i)]--;
        }

        for (int f : freq) {
            if (f != 0) return false;
        }

        return true;
    }
}
