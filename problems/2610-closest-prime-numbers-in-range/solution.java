
class Solution {
    

    public Solution() {
    }

    public int[] closestPrimes(int left, int right) {

        boolean[] primes = new boolean[right + 1];
        Arrays.fill(primes, true);
        findAllPrimesUntilN(primes);


        int prev = left, prev_min_idx = -1;
        while (prev <= right && !primes[prev]) prev++;
        int curr = prev + 1, curr_min_idx = -1;
        int min  = right + 1;
        while (curr <= right) {
            while (curr <= right && !primes[curr]) curr++;
            if (curr <= right && curr - prev < min) {
                min = curr - prev;
                prev_min_idx = prev;
                curr_min_idx = curr;
            }
            prev = curr;
            curr++;
        }

        return new int[] {prev_min_idx, curr_min_idx};
    }

    private void findAllPrimesUntilN(boolean[] primes) {
        // mark 0, 1 as non primes;
        primes[0] = primes[1] = false;

        for (int i = 2; i <= Math.sqrt(primes.length);) {
            if (!primes[i]) continue;
            // Mark all the multiples of i as non primes
            for (int j = i*i; j > 0 && j < primes.length; j += i) {
                primes[j] = false;
            }

            // Find next prime and repeat
            boolean nextPrimeExists = false;
            for (int j = i + 1; j < primes.length; j++) {
                if (primes[j]) {
                    i = j;
                    nextPrimeExists = true;
                    break;
                }
            }
            if (!nextPrimeExists) {
                break;
            }
        }
    }
}
