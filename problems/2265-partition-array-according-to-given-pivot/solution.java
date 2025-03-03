class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        int[] result = new int[nums.length];

        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                result[p] = nums[i];
                p++;
            }
        }

        int k = nums.length - 1;
        for (int j = k; k >= 0; k--) {
            if (nums[k] > pivot) {
                result[j] = nums[k];
                j--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pivot) {
                result[p] = nums[i];
                p++;
            }
        }
        
        return result;
    }
}
