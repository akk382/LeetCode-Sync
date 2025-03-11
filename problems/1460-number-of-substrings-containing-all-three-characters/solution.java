class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> abcMap = new HashMap<>();

        int resultCount = 0;
        int left = 0, right = 0;
        for (; right < s.length(); right++) {
            char currChar = s.charAt(right);
            Integer charCount = abcMap.getOrDefault(currChar, 0);
            abcMap.put(currChar, charCount + 1);

            if (abcMap.size() == 3) {
                resultCount += s.length() - right;

                do {
                    left = left + 1;
                    char reducedChar = s.charAt(left - 1);
                    Integer reducedCharCount = abcMap.get(reducedChar);
                    if (reducedCharCount == 1) {
                        abcMap.remove(reducedChar);
                    } else {
                        abcMap.put(reducedChar, reducedCharCount - 1);
                    }

                    if (abcMap.size() == 3) {
                        resultCount += s.length() - right;
                    }
                } while (abcMap.size() == 3);
            }
        }

        return resultCount;
    }
}
