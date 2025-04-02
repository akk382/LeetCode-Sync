class Solution {
    // https://www.youtube.com/watch?v=lB_gLotpnuY
    public long putMarbles(int[] weights, int k) {
        if (weights.length == k) {
            return 0;
        }
        int[] splitSums = new int[weights.length - 1];
        for (int i = 1; i < weights.length; i++) {
            splitSums[i - 1] = weights[i - 1] + weights[i];
        }
        Arrays.sort(splitSums);

        long maxSum = 0, minSum = 0;
        int i = splitSums.length - 1;
        while (splitSums.length - 1 - i < k - 1) {
            maxSum += splitSums[i]; // Last k - 1 splits sums (Max values)
            minSum += splitSums[splitSums.length - 1 - i]; // First k - 1 split sums (Min values)
            i--;
        }

        return maxSum - minSum;
    }
}
