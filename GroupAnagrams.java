// GroupAnagrams.java
// LeetCode 49: Group Anagrams

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> buckets = new HashMap<>();
        for (String s : strs) {
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int v : cnt) key.append('#').append(v);
            buckets.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(buckets.values());
    }

    public static void main(String[] args) {
        List<List<String>> groups = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        List<String> normalized = groups.stream()
            .map(list -> {
                List<String> copy = new ArrayList<>(list);
                Collections.sort(copy);
                return copy.toString();
            }).sorted().collect(Collectors.toList());
        System.out.println(normalized);
    }
}
