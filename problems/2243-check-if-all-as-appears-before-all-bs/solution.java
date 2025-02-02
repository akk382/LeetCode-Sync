class Solution {
    public boolean checkString(String s) {
        
        int indexOfFirstB = findIndexOfFirstB(s);

        if (indexOfFirstB == -1) { // All are a's
            return true;
        }

        for (int i = indexOfFirstB + 1; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                return false;
            }
        }

        return true;
    }

    private int findIndexOfFirstB(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                return i;
            }
        }
        return -1;
    }
}
