class Solution {
    public int longestNiceSubarray(int[] nums) {
        int sum = nums[0];
        int count = 1;
        int max_count = 1;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            while ((sum & nums[right]) != 0 && left < right) {
                sum ^= nums[left];
                left++;
                count--;
            }
            if ((sum & nums[right]) == 0) {
                count++;
                if (count > max_count) {
                    max_count = count;
                }
                sum |= nums[right];
            }
        }
        return max_count;
    }
}
