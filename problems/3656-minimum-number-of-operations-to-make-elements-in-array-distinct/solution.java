class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] lastEncounteredIndex = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                lastEncounteredIndex[i] = map.get(nums[i]);
            } else {
                lastEncounteredIndex[i] = i;
            }
            map.put(nums[i], i);
        }

        int max_unmatch = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (lastEncounteredIndex[i] != i && lastEncounteredIndex[i] > max_unmatch) {
                max_unmatch = lastEncounteredIndex[i];
            }
        }

        int div = (max_unmatch + 1) / 3;
        int rem = (max_unmatch + 1) % 3;
        return rem == 0 ? div : div + 1;
    }
}
