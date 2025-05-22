import java.util.HashMap;

public class twoSumHashMap {
    public static void main(String[] args) {

        int [] nums = {2, 7, 11, 15, 3};
        int target = 10;

        HashMap <Integer, Integer> map = new HashMap <>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println("[" + map.get(complement) + ", " + i + "]");
                return;
            }
            map.put(nums[i], i);

                }
            }
        }
