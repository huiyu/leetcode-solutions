import java.util.*;

public class Solution {

    public List<List<Integer>> twoSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 2) {
            return result;
        }
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        println(nums);

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < 0) {
                i++;
            } else if (sum > 0) {
                j--;
            } else {
                List<Integer> l = new ArrayList<>(2);
                l.add(nums[i]);
                l.add(nums[j]);
                result.add(l);
                while (nums[i + 1] > nums[i] && i < j) {
                    i++;
                }
                while (nums[j - 1] < nums[j] && i < j) {
                    j--;
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum < target) {
                    j++;
                } else if (sum > target){
                    k--;
                } else {
                    List<Integer> l = new ArrayList<>(3);
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    j++;
                    k--;
                    while (j < k && nums[j - 1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k + 1] == nums[k]) {
                        k--;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> nSum(int[] nums, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < n) {
            return result;
        }
        Arrays.sort(nums);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        println(solution.threeSum(new int[]{0, 0, 0}));
        println(solution.threeSum(new int[]{0, 0, 0, 0}));
        println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static void println(int[] a) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i : a) {
            builder.append(i).append(",");
        }
        if (a.length > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
    
    public static <E> void println(Collection<E> c) {
        StringBuilder builder = new StringBuilder();
        append(c, builder);
        System.out.println(builder.toString());
    }

    private static <E> void append(Collection<E> c, StringBuilder builder) {
        builder.append("{");
        if (c.size() > 0) {
            for (E e : c) {
                append(e, builder);
                builder.append(",");
            }
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("}");
    }

    private static <K, V> void append(Map<K, V> map, StringBuilder builder) {
        builder.append("{");
        for (Map.Entry<K, V> e : map.entrySet()) {
            String key = String.valueOf(e.getKey());
            builder.append(key).append(":");
            append(e.getValue(), builder);
            builder.append(",");
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("}");
    }

    private static void append(Object e, StringBuilder builder) {
        if (e == null) {
            builder.append("null");
        } else if (e.getClass().isArray()) {
            append((Object[]) e, builder);
        } else if (e instanceof List) {
            append((List<?>) e, builder);
        } else if (e instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) e;
            append(map, builder);
        } else {
            builder.append(String.valueOf(e));
        }
    }

}
