class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {

        // prepare an array of colors such that the first k - 1 colors are appended at the end
        // If given colors are 0100101, and k = 6. Then prepare an array and append the first k - 1 = 5 colors at the end
        // Like: 0100101 01001.
        // We do this only if the first and last of the given colors are different.

        if (colors[0] != colors[colors.length - 1]) {
            int[] tempColors = new int[colors.length + k - 1];
            int i = 0;
            // Copy all the eleements from the colors to tempColors
            for (; i < colors.length; i++) {
                tempColors[i] = colors[i];
            }

            // Copy the first k - 1 elements from the colors to last k - 1 positions of tempColors
            while (i < tempColors.length) {
                tempColors[i] = colors[i % colors.length];
                i++;
            }

            colors = tempColors;
        }

        long[] counterArray = new long[colors.length];
        counterArray[0] = 0L;

        // Iterate through the colors until the end;
        for (int i = 1; i < colors.length; i++) {
            if (colors[i - 1] != colors[i]) {
                counterArray[i] = counterArray[i - 1] + 1;
            } else {
                counterArray[i] = 0;
            }
        }

        int groupCounter = 0;

        for (long i = 0; i < counterArray.length; i++) {
            if (counterArray[(int) i] >= k - 1) {
                groupCounter++;
            }
        }

        return groupCounter;
        
    }
}
