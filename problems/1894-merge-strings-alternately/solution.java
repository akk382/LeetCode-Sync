class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();;

        int k = 0, i = 0, j = 0;
        for (; i < word1.length() && j < word2.length(); i++, j++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(j));
        }

        while (i < word1.length()) {
            result.append(word1.charAt(i));
            i++;
        }
        while (j < word2.length()) {
            result.append(word2.charAt(j));
            j++;
        }

        return result.toString();
    }
}
