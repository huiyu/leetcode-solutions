import java.util.*;

/**
 * Two Sum
 * @see https://leetcode.com/problems/two-sum/
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // TODO use int array instead of HashMap
        Map<Integer, Integer> indexByNumber = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            indexByNumber.put(target - nums[i], i);
            Integer index = indexByNumber.get(nums[i]);
            if (index != null && index != i) {
                return new int[] {i, index};
            }
        }

        for (int i = 0; i < nums.length; i++) {
            Integer index = indexByNumber.get(nums[i]);
            if (index != null && index != i) {
                return new int[] {i, index};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.twoSum(new int[] {2, 7, 11, 15}, 9));
        print(solution.twoSum(new int[] {3, 1, 5}, 6));
    }

    public static void print(int[] a) {
        if (a == null) {
            System.out.println("null");
        } else {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}
