class Solution {

    private int[] abcMap = new int[3];
    
    public int numberOfSubstrings(String s) {
        int resultCount = 0;
        int left = 0, right = 0;
        for (; right < s.length(); right++) {
            char currChar = s.charAt(right);
            int charCount = abcMap[currChar - 'a'];
            abcMap[currChar - 'a'] = charCount + 1;


            if (allCharsPresent()) {
                resultCount += s.length() - right;

                do {
                    left = left + 1;
                    char reducedChar = s.charAt(left - 1);
                    int reducedCharCount = abcMap[reducedChar - 'a'];
                    if (reducedCharCount == 1) {
                        abcMap[reducedChar - 'a'] = 0;
                    } else {
                        abcMap[reducedChar - 'a'] = reducedCharCount - 1;
                    }

                    if (allCharsPresent()) {
                        resultCount += s.length() - right;
                    }
                } while (allCharsPresent());
            }
        }

        return resultCount;
    }

    private boolean allCharsPresent() {
        return abcMap[0] != 0 && abcMap[1] != 0 && abcMap[2] != 0;
    }
}
