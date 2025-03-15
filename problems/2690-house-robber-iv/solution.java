class Solution {
    // https://youtu.be/OHZqAc6h3Us
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

            // count the values that are less than the mid.
            // Basically we are checking if we can form an array with atleast k size and <= mid;
            // If we can form then we need to iterate on the left of the search range, else, we have to search on the right range.
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
