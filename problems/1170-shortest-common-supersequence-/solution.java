class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = findLCS(str1, str2, str1.length(), str2.length());

        int scsLength = str1.length() + str2.length() - lcs.length() + 1;
        char[] scsArray = new char[scsLength];

        int i = 0, j = 0, k = 0, p = 0;
        while (i < str1.length() && j < str2.length() && k < lcs.length() && p < scsArray.length) {
             if (str1.charAt(i) == str2.charAt(j) && str2.charAt(j) == lcs.charAt(k)) {
                 // All the pointers point to the equal matching character.
                 // Add it to the scs and increment all
                 scsArray[p++] = str1.charAt(i);
                 i++;
                 j++;
                 k++;
             } else if (str1.charAt(i) == lcs.charAt(k)) {
                 scsArray[p++] = str2.charAt(j++);
             } else if (str2.charAt(j) == lcs.charAt(k)) {
                 scsArray[p++] = str1.charAt(i++);
             } else {
                 scsArray[p++] = str1.charAt(i++);
                 scsArray[p++] = str2.charAt(j++);
             }
        }

        while (i < str1.length() && p < scsArray.length) {
            scsArray[p++] = str1.charAt(i++);
        }

        while (j < str2.length() && p < scsArray.length) {
            scsArray[p++] = str2.charAt(j++);
        }


        return String.valueOf(scsArray);
    }

    private static String findLCS(String X, String Y, int m, int n) {

        int[][] L = new int[m + 1][n + 1];

        // Following steps build L[m+1][n+1] in bottom up
        // fashion. Note that L[i][j] contains length of LCS
        // of X[0..i-1] and Y[0..j-1]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j],
                            L[i][j - 1]);
            }
        }

        // Following code is used to print LCS
        int index = L[m][n];
        int temp = index;

        // Create a character array to store the lcs string
        char[] lcs = new char[index + 1];
        lcs[index]
                = '\u0000'; // Set the terminating character

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            // If current character in X[] and Y are same,
            // then current character is part of LCS
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                // Put current character in result
                lcs[index - 1] = X.charAt(i - 1);

                // reduce values of i, j and index
                i--;
                j--;
                index--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i - 1][j] > L[i][j - 1])
                i--;
            else
                j--;
        }

        return String.valueOf(lcs);
    }
}
