class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int y = x;
        int num = 0;
        while (y != 0) {
            int r = y % 10;
            num = num * 10 + r;
            y /= 10;
        }

        if (num == x) {
            return true;
        }
        return false;
    }
}
