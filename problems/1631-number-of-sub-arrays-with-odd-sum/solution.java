class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int odd_count = 0;
        int even_count = 1;
        int total = 0;
        int prefix_sum = 0;
        for (int elem : arr) {
            prefix_sum += elem;
            if ((prefix_sum & 1) != 0) {
                total = (total + even_count) % MOD;
                odd_count++;
            } else {
                total = (total + odd_count) % MOD;
                even_count++;
            }
        }
        return total;
    }
}
