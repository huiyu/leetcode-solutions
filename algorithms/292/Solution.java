public class Solution {
    public boolean canWinNim(int n) {
        // a[i] = !a[i - 1] || !a[i - 2] || !a[i - 3]
        return (n % 4) != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + ": " + solution.canWinNim(i));
        }
        long t2 = System.currentTimeMillis();

        System.out.println(t2 - t1);
    }
}
