class Solution {
    public int minimumRecolors(String blocks, int k) {

        int[] wCounter = new int[blocks.length()];
        wCounter[0] = blocks.charAt(0) == 'W' ? 1 : 0;
        for (int i = 1; i < blocks.length(); i++) {
            wCounter[i] = blocks.charAt(i) == 'W' ? wCounter[i-1] + 1 : wCounter[i - 1];
        }

        int i = k - 1;  // We start from the k - 1 th position.
        int minNeeded = wCounter[i++];
        while (i < blocks.length()) {
            if (wCounter[i] - wCounter[i - k] < minNeeded) {
                minNeeded = wCounter[i] - wCounter[i - k];
            }
            i++;
        }

        return minNeeded;
    }
}
