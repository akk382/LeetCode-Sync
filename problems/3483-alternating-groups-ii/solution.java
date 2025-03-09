class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {

        int length = colors.length;
        if (colors[0] != colors[colors.length - 1]) {
            length = colors.length + k - 1;
        }

        int counter = 0;
        int groupCounter = 0;
        for (int i = 1; i < length; i++) {
            if (colors[(i - 1) % colors.length] != colors[i % colors.length]) {
                counter++;
                if (counter >= k - 1) {
                    groupCounter++;
                }
            } else {
                counter = 0;
            }
        }

        return groupCounter;       
    }
}
