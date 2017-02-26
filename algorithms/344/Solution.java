public class Solution {
    public String reverseString(String s) {
        char[] a = s.toCharArray();
        int len = a.length;
        char[] b = new char[len];
        for (int i = 0; i < len; i++) {
            b[len - 1 -i] = a[i];
        }
        return new String(b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseString("abc"));
        System.out.println(solution.reverseString("a"));
        System.out.println(solution.reverseString("hello"));
        System.out.println(solution.reverseString(""));
    }
}
