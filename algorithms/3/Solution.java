public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] a = s.toCharArray();
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            // check if a[i] is in sub array a[start...i-1]
            for (int j = start; j < i; j++) {
                if (a[j] == a[i]) {
                    int l = i - start;
                    maxLen = maxLen > l ? maxLen : l;
                    start = j + 1;
                    break;
                }
            }
        }

        int l = len - start;
        maxLen = maxLen > l ? maxLen : l;
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("c"));
        System.out.println(solution.lengthOfLongestSubstring("au"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
