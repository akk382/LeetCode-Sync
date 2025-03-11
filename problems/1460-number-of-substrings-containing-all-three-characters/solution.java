class Solution {

    private int[] abcMap = new int[3];
    
    public int numberOfSubstrings(String s) {
        char[] charArr = s.toCharArray();
        int resultCount = 0;
        for (int right = 0, left = 0; right < charArr.length; right++) {
            char currChar = charArr[right];
            int charCount = abcMap[currChar - 'a'];
            abcMap[currChar - 'a'] = charCount + 1;


            if (allCharsPresent()) {
                resultCount += charArr.length - right;

                do {
                    left = left + 1;
                    char reducedChar = charArr[left - 1];
                    int reducedCharCount = abcMap[reducedChar - 'a'];
                    if (reducedCharCount == 1) {
                        abcMap[reducedChar - 'a'] = 0;
                    } else {
                        abcMap[reducedChar - 'a'] = reducedCharCount - 1;
                    }

                    if (allCharsPresent()) {
                        resultCount += charArr.length - right;
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
