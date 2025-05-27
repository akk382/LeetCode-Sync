class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] temp = new int[nums.length + 1];
        for (int[] query : queries) {
            temp[query[0]] += 1;
            temp[query[1] + 1] -=1;
        }

        for (int i = 1; i < nums.length; i++) {
            temp[i] += temp[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
