class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {

        int length = colors.length;
        if (colors[0] != colors[colors.length - 1]) {
            length = colors.length + k - 1;
        }

        long[] counterArray = new long[length];
        counterArray[0] = 0L;

        // Iterate through the colors until the end;
        for (int i = 1; i < length; i++) {
            if (colors[(i - 1) % colors.length] != colors[i % colors.length]) {
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
