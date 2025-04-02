class Solution {
    public long maximumTripletValue(int[] nums) {
        int[] maxOf_i_to_end = new int[nums.length + 1];
        maxOf_i_to_end[nums.length] = nums[nums.length - 1];
        int[] minOf_i_to_end = new int[nums.length + 1];
        minOf_i_to_end[nums.length] = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            maxOf_i_to_end[i] = Math.max(maxOf_i_to_end[i + 1], nums[i]);
            minOf_i_to_end[i] = Math.min(minOf_i_to_end[i + 1], nums[i]);
        }

        long max_value = -1;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                long possibly_max_value_1 = (long) (nums[i] - nums[j]) * maxOf_i_to_end[j + 1];
                long possibly_max_value_2 = (long) (nums[i] - nums[j]) * minOf_i_to_end[j + 1];

                max_value = Math.max(max_value, Math.max(possibly_max_value_1, possibly_max_value_2));
            }
        }

        return max_value > 0 ? max_value : 0;
    }
}
