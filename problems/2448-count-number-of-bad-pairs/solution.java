class Solution {
    public long countBadPairs(int[] nums) {
        long len = nums.length;
        long total_pairs = (len * (len - 1)) / 2;
        long good_pairs = 0;
        Map<Long, Long> hashMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Long currentValue = hashMap.getOrDefault(Long.valueOf(nums[i] - i), 0L);
            good_pairs += currentValue;
            hashMap.put(Long.valueOf(nums[i] - i), currentValue + 1);
        }

        return total_pairs - good_pairs;
    }
}
