class Solution {
    public boolean divideArray(int[] nums) {
        int[] pairs = new int[501];

        for (int i = 0; i < nums.length; i++) {
            pairs[nums[i]] += 1;
        }

        for (int i = 1; i < 501; i++) {
            if (pairs[i] % 2 != 0) {
                return false;
            }
        }
        
        return true;
    }
}
