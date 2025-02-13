class Solution {
    public int minOperations(int[] nums, int k) {

        Queue<Long> pq = new PriorityQueue<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            pq.add(Long.valueOf(nums[i]));
        }

        int count = 0;
        while (pq.peek() != null && pq.size() > 1 && pq.peek() < k) {
            Long min1 = pq.poll();
            Long min2 = pq.poll();
            Long op = (min1 * 2) + min2;
            pq.add(op);
            count++;
        }

        return count;

    }
}
