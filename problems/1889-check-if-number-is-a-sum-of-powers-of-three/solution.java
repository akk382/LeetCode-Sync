class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n % 3 != 2 && n >= 3) {
            n /= 3;
        }
        if (n % 3 == 2) {
            return false;
        }
        return true;
    }
}
