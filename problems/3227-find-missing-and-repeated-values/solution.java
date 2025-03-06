class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        int actualSum = 0;
        boolean[] map = new boolean[grid.length * grid.length];
        boolean found = false;
        // Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (map[grid[i][j] - 1]) {
                    result[0] = grid[i][j];
                    found = true;
                }
                if (!found) {
                    map[grid[i][j] - 1] = true;
                }
                actualSum += grid[i][j];
            }
        }

        int nSquare = (int) Math.pow(grid.length, 2);

        result[1] = (nSquare*(nSquare + 1) / 2) - actualSum + result[0];
        return result;
    }
}
