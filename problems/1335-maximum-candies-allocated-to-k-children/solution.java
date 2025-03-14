class Solution {
    public int maximumCandies(int[] candies, long k) {
        long totalCandies = 0;
        for (int j : candies) {
            totalCandies += j;
        }
        
        if (totalCandies < k) {
            return 0;
        }

        long min = totalCandies / k;

        if (min == 1) {
            return 1;
        }

        // Using binary search to check for the next min between 0, min
        // https://www.youtube.com/watch?v=jpKfrXetb9Q
        int found = 0;
        long res;
        long low = 0, high = min;
        while (true) {
            if (high >= low) {
                min = ((high - low) / 2) + low;
            } else {
                return found;
            }
            res = 0;
            for (long candy : candies) {
                if (candy >= min && min > 0) {
                    res += (int) candy / min;
                }
            }
            if (res < k) {
                high = min - 1;
            } else {
                low = min + 1;
                found = (int) min;
            }
        }
    }
}
