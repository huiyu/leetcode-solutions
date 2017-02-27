public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }

        char[][] m = new char[len][];

        int minLen = strs[0].length();
        for (int i = 0; i < len; i++) {
            m[i] = strs[i].toCharArray();
            minLen = minLen <= m[i].length ? minLen : m[i].length;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = m[0][i];
            for (int j = 1; j < len; j++) {
                if (m[j][i] != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {
            "123",
            "1234",
            "1235"
        };

        System.out.println(solution.longestCommonPrefix(strs));

    }
}
