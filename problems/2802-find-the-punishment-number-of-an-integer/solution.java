class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int i_square = i * i;
            if (recurse(0, 0, i, String.valueOf(i_square))) {
                res += i_square;
            }
        }
        return res;
    }

    private boolean recurse(int i, int curr, int target, String str) {
        if (i == str.length() && curr == target) {
            return true;
        }
        for (int j = i; j < str.length(); j++) {
            if (recurse(j + 1, curr + Integer.parseInt(str.substring(i, j + 1)), target, str)) {
                return true;
            }
        }
        return false;
    }
}
