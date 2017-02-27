import java.util.*;

/**
 * 3Sum Closest
 * @see https://leetcode.com/problems/3sum-closest/
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            int sum = 0;
            for (int num : nums) {
                sum+=num;
            }
            return sum;
        }
        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;
        int result  = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                System.out.println("SUM: " + sum);
                int dist = Math.abs(sum - target);
                result = dist < closest ? sum : result;
                j++;
                k--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
        System.out.println(solution.threeSumClosest(new int[] {1, 1, 1, 0}, -100));
    }
}
