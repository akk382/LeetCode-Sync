class Solution {

    boolean[] vowels;
    int[] vowelMap;

    public Solution() {
        vowels = new boolean[26];
        vowels['a' - 'a'] = true;
        vowels['e' - 'a'] = true;
        vowels['i' - 'a'] = true;
        vowels['o' - 'a'] = true;
        vowels['u' - 'a'] = true;

        vowelMap = new int[26];
    }

    public long countOfSubstrings(String word, int k) {

        // https://www.youtube.com/watch?v=dEHtsg2O7BE

        // Prepare an array to track next consonant's position
        int[] nextConsonantAt = new int[word.length()];
        int nextConsonantPos = word.length();

        int j = word.length() - 1;
        do {
            nextConsonantAt[j] = nextConsonantPos;
            if (!isVowel(word.charAt(j))) {
                nextConsonantPos = j;
            }
            j--;
        } while (j >= 0);

        long resultCount = 0;
        int consonantCount = 0;
        int left = 0, right = 0;
        for (; right < word.length(); right++) {
            char currChar = word.charAt(right);
            if (isVowel(currChar)) {
                int charCount = vowelMap[currChar - 'a'];
                vowelMap[currChar - 'a'] = charCount + 1;
            } else {
                consonantCount++;
            }

            while (consonantCount > k) {
                left = left + 1;
                char reducedchar = word.charAt(left - 1);
                if (isVowel(reducedchar)) {
                    int reducedCharCount = vowelMap[reducedchar - 'a'];
                    if (reducedCharCount - 1 == 0) {
                        vowelMap[reducedchar - 'a'] = 0;
                    } else {
                        vowelMap[reducedchar - 'a'] = reducedCharCount - 1;
                    }
                } else {
                    consonantCount--;
                }
            }

            if (allVowelsExists() && consonantCount == k) {
                resultCount += nextConsonantAt[right] - right;
                do {
                    left = left + 1;
                    char reducedchar = word.charAt(left - 1);
                    if (isVowel(reducedchar)) {
                        int reducedCharCount = vowelMap[reducedchar - 'a'];
                        if (reducedCharCount - 1 == 0) {
                            vowelMap[reducedchar- 'a'] = 0;
                        } else {
                            vowelMap[reducedchar - 'a'] = reducedCharCount - 1;
                        }
                    } else {
                        consonantCount--;
                    }
                    if (allVowelsExists() && consonantCount == k) {
                        resultCount += nextConsonantAt[right] - right;
                    }
                } while (allVowelsExists() && consonantCount == k);
            }
        }

        return resultCount;   
    }

    private boolean allVowelsExists() {
        return vowelMap[0] != 0 && vowelMap[4] != 0 && vowelMap[8] != 0
                && vowelMap[14] != 0 && vowelMap[20] != 0;
    }

    private boolean isVowel(char c) {
        return vowels[c - 'a'];
    }
}
