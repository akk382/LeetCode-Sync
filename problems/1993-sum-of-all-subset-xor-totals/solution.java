class Solution {
    public int subsetXORSum(int[] nums) {
        int result = 0;
        int until = (int) Math.pow(2, nums.length);
        for (int mask = 1; mask < until; mask++) {
            result += xorSumOfSubset(nums, mask);
        }
        return result;
    }

    private int xorSumOfSubset(int[] nums, int mask) {
        int n_bits = (int) (Math.log(mask) / Math.log(2));
        int xor_sum = 0;
        for (int i = 0; i <= n_bits; i++) {
            if ((mask & (1 << i)) != 0) {
                xor_sum ^= nums[i];
            }
        }
        return xor_sum;
    }
}
