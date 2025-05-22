import java.util.Arrays;

public class ValidAnagramSort {
    public static void main(String[] args) {

        String s = "listen";
        String n = "silent";

        System.out.println(isAnagram(s, n));
    }
    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);

        }
    }
