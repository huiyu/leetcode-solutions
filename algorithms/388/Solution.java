import java.util.*;

/**
 * Longest Absolute File Path
 * @see https://leetcode.com/problems/longest-absolute-file-path/
 */
public class Solution {

    public int lengthLongestPath(String input) {

        String[] tokens = input.split("\n");

        LinkedList<Integer> stack = new LinkedList<Integer>();
        int maxLength = 0;
        for (String token : tokens) {
            boolean isFile = false;
            int length = 0;
            int depth = 0;

            char[] arr = token.toCharArray();
            for (char c : arr) {
                if (c == '\t')
                    depth++;
                else {
                    if (c == '.')
                        isFile = true;
                    length++;
                }
            }

            int popNum = stack.size() - depth;

            for (int i = 0; i < popNum; i++) {
                stack.pop();
            }
            stack.push(length);

            if (isFile) {
                int totalLength = 0;
                if (!stack.isEmpty()) {
                    for (Integer len : stack) {
                        totalLength += len;
                        totalLength++;
                    }
                    totalLength--;
                }
                if (totalLength >= maxLength) {
                    maxLength = totalLength;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
