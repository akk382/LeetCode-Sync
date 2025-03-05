class Solution {
    public long coloredCells(int n) {

        // Approach:
        // This is the same submission as before, just removed the commented BigInteger code.

        // If we observe the pattern, we will see every minute, we had to color 4 more colors than previously colored count. Let's say, if we color x boxes previously, then we need to color x + 4 boxes now.
        // So, the pattern is -> 1, 4, 8, 12, 16, .....
        // = 1, 4*1, 4*2, 4*3, 4*4, ..... 4 * (n-1) { this is at nth minute }
        // So, the total number of colored squares = 
        // 1 + 4 * (1 + 2 + 3 + .... (n-1))
        // = 1 + 4 * (((n-1) * n) / 2) = 1 + 2 * n * (n - 1)

        long x = n;
        return 1 + 2 * (x - 1) * x;
    }
}
