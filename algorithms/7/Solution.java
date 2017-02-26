/**
 * Reverse Integer
 * @see https://leetcode.com/problems/reverse-integer/
 */
public class Solution {

    public int reverse(int x) {
        boolean isPositive = x >= 0;

        char[] a = String.valueOf(isPositive ? x : -x).toCharArray();
        int mid = a.length / 2;
        for (int i = 0; i < mid; i++) {
            char tmp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = tmp;
        }

        try {
            int res = Integer.parseInt(new String(a));
            return isPositive ? res : -res;
        } catch(NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(10));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(1534236469));
    }
}
