class Solution {
    public int maximumSum(int[] nums) {
        
        // Calculate the sum of digits of all the elements in num and create a hashtable with key as sum of digits and value as a List or elements of nums whose sum of digits equals to key.

        Map<Long, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long sum = calculateSumOfDigits(nums[i]);
            Queue<Integer> pq = map.getOrDefault(sum, new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer i1, Integer i2) {
                        return Integer.compare(i2, i1);
                    }
                }
            ));
            pq.add(nums[i]);
            map.put(sum, pq);
        }

        AtomicInteger max = new AtomicInteger(-1);
        map.entrySet().stream().filter(e -> e.getValue().size() > 1).forEach(e -> {
            int max1 = e.getValue().poll();
            int max2 = e.getValue().poll();
            int sum = max1 + max2;
            max.set(max.get() > sum ? max.get() : sum);
        });

        return max.get();
    }

    private long calculateSumOfDigits(int elem) {
        long sum = 0;
        while (elem / 10 != 0) {
            sum += elem % 10;
            elem /= 10;
        }
        sum += elem;
        return sum;
    }
}
