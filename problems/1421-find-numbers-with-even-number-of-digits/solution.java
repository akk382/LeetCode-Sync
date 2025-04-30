class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int len = 0;
            while (num != 0) { num = num / 10; len++; }
            if (len != 0 && len % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
