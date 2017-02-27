/**
 * ZigZag Conversion
 * @see https://leetcode.com/problems/zigzag-conversion/
 *
 * numRows = 1: 0 1 2 3 4
 *
 * numRows = 2: 0 2 4 6
 *              1 3 5 7
 *
 * numRows = 3: 0   4   8
 *              1 3 5 7 9
 *              2   6   10
 *
 * numRows = 4: 0     6     12
 *              1   5 7   11
 *              2 4   8 10
 *              3     9
 */
public class Solution {
    public String convert(String s, int numRows){
        if (numRows == 1) return s;

        char[] a = s.toCharArray();
        int len = a.length;
        char[] b = new char[len];
        int step = (numRows - 1) * 2;

        int k = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j+=step) {
                b[k++] = a[j];
                if (i != 0 && i != numRows - 1) {
                    int mid = j + 2 * (numRows - i - 1);
                    if (mid < len) {
                        b[k++] = a[mid];
                    }
                }
            }
        }
        return new String(b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("ABCD", 3));
        System.out.println(solution.convert("PAYPALISHIRING", 1));
        System.out.println(solution.convert("PAYPALISHIRING", 2));
        System.out.println(solution.convert("PAYPALISHIRING", 3));
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }
}
