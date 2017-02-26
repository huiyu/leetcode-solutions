public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x >= 0 && x < 10) return true;

        int len = (int) Math.log10(x) + 1;
        int[] a = new int[len];
        int i = 0;
        while (x > 0) {
            a[i++] = x % 10;
            x = x / 10;
        }

        for (int j = 0; j < len / 2; j++) {
            if (a[j] != a[len - j - 1t ]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(22));
        System.out.println(solution.isPalindrome(1234));
        System.out.println(solution.isPalindrome(1234));
        System.out.println(solution.isPalindrome(12344321));
        System.out.println(solution.isPalindrome(123404321));
    }
}
