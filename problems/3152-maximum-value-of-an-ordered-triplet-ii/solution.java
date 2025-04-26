class Solution {
    public long maximumTripletValue(int[] nums) {
        int l = nums.length;
        int[] leftMax = new int[l];
        int[] rightMax = new int[l];

        for (int j = 1; j < l - 1; j++) {
            leftMax[j] = Math.max(leftMax[j - 1], nums[j - 1]);
            rightMax[l - j - 1] = Math.max(rightMax[l - j], nums[l - j]);
        }

        long res = 0;
        for (int j = 1; j < l - 1; j++) {
            res = Math.max(res, (long) (leftMax[j] - nums[j]) * (rightMax[j]));
        }

        return res;
    }
}
