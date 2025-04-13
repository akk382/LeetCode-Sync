class Solution {
    private final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        if (n % 2 == 0) { // even
            long exp5 = exponentiation(5, n/2);
            long exp4 = exponentiation(4, n/2);
            long ans = (exp5 * exp4) % MOD;
            return (int) ans;
        } else {
            long exp5 = exponentiation(5, (n/2) + 1);
            long exp4 = exponentiation(4, n/2);
            long ans = (exp5 * exp4) % MOD;
            return (int) ans;
        }
    }

    private long exponentiation(int a, long n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return a;
        }
        if (n % 2 == 0) {
            long expBy2 = exponentiation(a, n / 2);
            return (expBy2 * expBy2) % MOD;
        } else {
            return (a * exponentiation(a, n - 1)) % MOD;
        }
    }
}
