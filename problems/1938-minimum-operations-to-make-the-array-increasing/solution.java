class Solution {
    public int minOperations(int[] nums) {
        int ops = 0;
        for (int i = 1, prev = nums[0]; i < nums.length; i++) {
            if (nums[i] <= prev) {
                ops += 1 + prev - nums[i];
                prev++;
            } else {
                prev = nums[i];
            }
        }
        return ops;
    }
}
