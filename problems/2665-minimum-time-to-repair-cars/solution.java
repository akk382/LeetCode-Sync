class Solution {
    public long repairCars(int[] ranks, int cars) {

        int max = ranks[0];
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] > max) {
                max = ranks[i];
            }
        }

        long result = 0;
        long low = 1, high = (long) max * cars * cars;
        while (high >= low) {
            long mid = (high - low) / 2 + low;

            long nCars = 0; // cars that can be remaired in 'mid' time;
            for (int rank : ranks) {
                nCars += (long) Math.sqrt((double) mid / rank);
            }
            if (nCars >= cars) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}
