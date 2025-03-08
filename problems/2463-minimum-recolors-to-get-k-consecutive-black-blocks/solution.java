class Solution {
    public int minimumRecolors(String blocks, int k) {

        int numWhites = 0;
        int minNeeded = k + 1; 

        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                numWhites++;    
            }

            if (i >= k && blocks.charAt(i - k) == 'W') {
                numWhites--;    
            }

            if (i >= k - 1) {
                minNeeded = Math.min(minNeeded, numWhites);
            }
        }

        return minNeeded;
    }
}
