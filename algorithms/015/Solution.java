import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        return nsum(0, 3, nums);
    }

    public List<List<Integer>> nsum(int target, int n, int[] nums) {
        Arrays.sort(nums);
        return nsum(target, n, nums, 0, nums.length);
    }

    public List<List<Integer>> nsum(int target, int n, int[] nums, int start, int end) {
        int size = end - start;
        if (size < n) {
            return new ArrayList<>();
        }

        if (n == 1) {
            List<List<Integer>> res = new ArrayList<>();
            int targetIndex = Arrays.binarySearch(nums, start, end, target);
            if (targetIndex >= 0) {
                LinkedList<Integer> l = new LinkedList<>();
                l.add(target);
                res.add(l);
            }
            return res;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < end - n + 1; i++) {
            if (i > start && nums[i - 1] == nums[i])
                continue;

            int num = nums[i];
            List<List<Integer>> subRes = nsum(target - num, n - 1, nums, i + 1, end);

            for (List<Integer> l : subRes) {
                LinkedList<Integer> ll = (LinkedList<Integer>) l;
                ll.addFirst(num);
                res.add(ll);
            }
        }
        return res;
    }
}




