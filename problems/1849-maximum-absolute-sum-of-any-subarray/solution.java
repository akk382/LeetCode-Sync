class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int max = 0;
        int min = 0;
        max = Math.max(nums[0], max);
        min = Math.min(nums[0], min);
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        
        return Math.abs(max - min);
    }
}
