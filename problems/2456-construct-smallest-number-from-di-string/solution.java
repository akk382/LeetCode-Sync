class Solution {
    public String smallestNumber(String pattern) {
        return smallestDINumber(pattern);
    }

    /*
    From discussions:

    HINT: you can solve the problem in O(n) time and O(n) memory.

    Pad the pattern with an artificial "I" at the front
    Count how many "D" directly follow each "I"
    when you encounter "I", place the smallest available element plus the offset determined above
    when you encounter "D", place the element one less than the previous value

    */

    class Tuple {
        private final int prevPos;
        private final int countOfDs;
        private final int nextPos;

        public Tuple(int prevPos, int countOfDs, int nextPos) {
            this.prevPos = prevPos;
            this.countOfDs = countOfDs;
            this.nextPos = nextPos;
        }
    }

    private String smallestDINumber(String pattern) {
        int[] freq = new int[pattern.length() + 1];
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= pattern.length() + 1; i++) {
            queue.add(i);
        }

        // Find the first D, and count until I
        int from = 0;
        while(true) {
            Tuple tuple = getPrevPositionOfNextDAndCount(pattern, from);
            if (tuple == null) {
                break;
            }
            from = tuple.nextPos;
            int count = tuple.countOfDs;
            for (int k = tuple.prevPos; k < tuple.nextPos && k < freq.length; k++) {
                freq[k] = count;
                count--;
            }
        }

        // Get the least element from the queue and increment is by the freq[i];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            int least = queue.peek() + freq[i];
            queue.remove(least);
            result.append(least);
        }
        return result.toString();

        //-  I I I D I D D D
    }

    private Tuple getPrevPositionOfNextDAndCount(String pattern, int from) {
        int j = from;
        while (j < pattern.length() && pattern.charAt(j) != 'D') {
            j++;
        }
        if (j == pattern.length()) {
            return null;
        }
        int prevPos = j;
        int dCount = 0;
        while (j < pattern.length() && pattern.charAt(j) != 'I') {
            dCount++;
            j++;
        }
        return new Tuple(prevPos, dCount, j);
    }
}
