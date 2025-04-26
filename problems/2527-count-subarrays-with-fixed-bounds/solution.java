class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int m = -1;     // most recent minK index
        int M = -1;     // most recent maxK index
        int O = -1;     // most recent Out-of-bounds index

        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minK) {
                m = i;
            }
            if (nums[i] == maxK) {
                M = i;
            }
            if (nums[i] < minK || nums[i] > maxK) {
                O = i;
            }

            if (m != -1 && M != -1) {
                int leastIndex = Math.min(m, M);

                if (O < leastIndex) {
                    count = count + leastIndex - (O + 1) + 1;
                }
            }
        }

        return count;
    }
}
