class Solution {
    public int minCapability(int[] nums, int k) {
        // find the min of the capability = min(nums);

        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] > max) {
                max = nums[i];
            }
        }

        // binary search range = [min, max];
        int result = -1;
        while (max >= min) {
            int mid = (max - min) / 2 + min;

            int count = 0;
            for (int i = 0; i < nums.length;) {
                if (nums[i] <= mid) {
                    count++;
                    i+=2;
                } else {
                    i+=1;
                }
            }
            if (count >= k) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return result;
    }
}
