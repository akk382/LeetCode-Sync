class Solution {
    public int[] applyOperations(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0 && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int i = 0;
        int j = -1;
        while (i < nums.length) {
            while (i < nums.length && nums[i] != 0) i++;
            if (j == -1) j = i + 1;
            while (j < nums.length && nums[j] == 0) j++;
            if (i < nums.length && j < nums.length) {
                nums[i] = nums[j];
                nums[j] = 0;
                j = j + 1;
            } else {
                break;
            }
        }

        return nums;   
    }
}
