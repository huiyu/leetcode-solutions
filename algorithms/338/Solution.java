/**
 * Counting Bits
 * @see https://leetcode.com/problems/counting-bits/
 */
public class Solution {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[] {0};
        } else if (num == 1) {
            return new int[] {0, 1};
        } else if (num == 2) {
            return new int[] {0, 1, 1};
        }
        
        int[] a = new int[num + 1];
        int base = 2;
        a[0] = 0;
        a[1] = 1;
        a[2] = 1;
        for (int i = 3; i <= num; i++) {
            if (base * 2 == i) {
                base = i;
                a[i] = 1;
            } else {
                a[i] = 1 + a[i % base];
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.countBits(5));
        print(solution.countBits(6));
        print(solution.countBits(7));
        print(solution.countBits(15));
    }

    static void print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i).append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }
}
