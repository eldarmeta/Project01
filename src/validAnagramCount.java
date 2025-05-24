public class validAnagramCount {
    public static void main(String[] args) {

        String s = "listen";
        String t = "silent";

        System.out.println(isAnagram(s, t));

    }
        public static boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) return false;

      int [] count = new int [26];

      for(int i = 0; i < s.length(); i++) {
          count[s.charAt(i) - 'a']++;
          count[s.charAt(i) - 'z']--;
      }
      for (int c : count) {
          if (c != 0) return false
      }
return true;

    }
}
