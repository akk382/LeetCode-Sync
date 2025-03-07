
class Solution {
    public int[] closestPrimes(int left, int right) {

        if (left == 1) {
            left = left + 1;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }

        int minIdx = -1;
        int min = right + 1;

        if (list.size() <= 1) {
            return new int[]{-1, -1};
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) < min) {
                minIdx = i;
                min = list.get(i) - list.get(i - 1);
            }
        }
        return new int[]{list.get(minIdx - 1), list.get(minIdx)};
        
    }

    private boolean isPrime(int num) {
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
