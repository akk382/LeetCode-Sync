class Solution {
    public String clearDigits(String s) {

        char[] charArr = new char[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                charArr[j] = s.charAt(i);
                j++;
            } else {
                j = j == 0 ? 0 : j - 1;
            }
        }

        return new String(charArr, 0, j);
    }
}
