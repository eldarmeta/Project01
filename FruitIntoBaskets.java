// FruitIntoBaskets.java
// LeetCode 904: Fruit Into Baskets

import java.util.*;

public class FruitIntoBaskets {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int best = 0, left = 0;
        for (int right = 0; right < fruits.length; right++) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            while (basket.size() > 2) {
                int f = fruits[left];
                basket.put(f, basket.get(f) - 1);
                if (basket.get(f) == 0) basket.remove(f);
                left++;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1,2,1}));               // 3
        System.out.println(totalFruit(new int[]{0,1,2,2}));             // 3
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));           // 4
    }
}
