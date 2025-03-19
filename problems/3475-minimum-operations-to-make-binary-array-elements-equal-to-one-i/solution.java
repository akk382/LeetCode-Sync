class Solution {
    public int minOperations(int[] nums) {
        int ops = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ops++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }
        return ops;
    }
}
