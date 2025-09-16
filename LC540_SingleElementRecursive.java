public class LC540_SingleElementRecursive {
    public static int singleNonDuplicate(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left) / 2;
        if (mid % 2 == 1) mid--;
        if (nums[mid] == nums[mid + 1]) {
            return helper(nums, mid + 2, right);
        } else {
            return helper(nums, left, mid);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(a));
    }
}