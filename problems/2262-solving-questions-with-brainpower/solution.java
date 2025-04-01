class Solution {
    public long mostPoints(int[][] questions) {
        int max_size = questions.length + 1;
        for (int i = 0; i < questions.length; i++) {
            max_size = Math.max(questions[i][1] + i + 1, max_size);
        }

        long[] result = new long[max_size + 1];

        for (int i = questions.length - 1; i >= 0; i--) {
            result[i] = Math.max(questions[i][0] + result[i + questions[i][1] + 1], result[i + 1]);
        }

        return result[0];
    }
}
