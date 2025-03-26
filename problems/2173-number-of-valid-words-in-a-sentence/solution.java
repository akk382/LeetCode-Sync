class Solution {
    public int countValidWords(String sentence) {
        String[] tokens = sentence.split(" ");
        int count = 0;
        for (String token : tokens) {
            if (token != null && token.isBlank()) {
                continue;
            }
            char[] charArray = token.toCharArray();
            boolean isNotAToken = tokenContainsDigits(charArray) || tokenContainsPuntuationOtherThanEnd(charArray) ||
                    tokenContainsMoreThanOneHyphen(charArray) || tokenStartsOrEndsWithHyphen(charArray);

            if (!isNotAToken) {
                count++;
            }
        }

        return count;
    }

    private boolean tokenStartsOrEndsWithHyphen(char[] charArray) {
        return charArray[0] == '-' || charArray[charArray.length - 1] == '-';
    }

    private boolean tokenContainsMoreThanOneHyphen(char[] charArray) {
        int hyphenCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '-') {
                if (i > 0 && charArray[i - 1] >= 97 && charArray[i - 1] <= 122 && i + 1 < charArray.length && charArray[i + 1] >= 97 && charArray[i + 1] <= 122) {
                    hyphenCount++;
                    if (hyphenCount > 1) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean tokenContainsPuntuationOtherThanEnd(char[] charArray) {
        char[] puntuations = {'!', '.', ','};
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if ((puntuations[0] == ch || puntuations[1] == ch || puntuations[2] == ch)
                && (i != charArray.length - 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean tokenContainsDigits(char[] charArray) {

        for (char ch : charArray) {
            if (ch >= 48 && ch <= 57) {
                return true;
            }
        }
        return false;
    }
}
