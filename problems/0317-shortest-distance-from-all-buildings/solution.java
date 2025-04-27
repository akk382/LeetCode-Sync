class Solution {
    public int shortestDistance(int[][] grid) {
        List<int[]> buildings = new ArrayList<>();
        List<int[]> empties = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {   // grid.size = number of rows
            for (int j = 0; j < grid[i].length; j++) {    // grid[i].size = number of columns
                if (grid[i][j] == 1) {
                    buildings.add(new int[]{i, j});
                } else if (grid[i][j] == 0) {
                    empties.add(new int[]{i, j});
                }
            }
        }

        int totalSum = Integer.MAX_VALUE;
        for (int[] start : empties) {

            int[][] distance = new int[grid.length][grid[0].length];    // This also acts as a visited array.
            for (int[] dist : distance) {
                Arrays.fill(dist, -1);
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            distance[start[0]][start[1]] = 0;
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int[] left = new int[]{curr[0], curr[1] - 1};
                int[] right = new int[]{curr[0], curr[1] + 1};
                int[] up = new int[]{curr[0] - 1, curr[1]};
                int[] down = new int[]{curr[0] + 1, curr[1]};
                if (left[1] >= 0 && grid[left[0]][left[1]] != 2 && distance[left[0]][left[1]] == -1) {
                    distance[left[0]][left[1]] = distance[curr[0]][curr[1]] + 1;
                    if (grid[left[0]][left[1]] != 1) {
                        queue.add(left);
                    }
                }
                if (right[1] < grid[0].length && grid[right[0]][right[1]] != 2 && distance[right[0]][right[1]] == -1) {
                    distance[right[0]][right[1]] = distance[curr[0]][curr[1]] + 1;
                    if (grid[right[0]][right[1]] != 1) {
                        queue.add(right);
                    }
                }
                if (up[0] >= 0 && grid[up[0]][up[1]] != 2 && distance[up[0]][up[1]] == -1) {
                    distance[up[0]][up[1]] = distance[curr[0]][curr[1]] + 1;
                    if (grid[up[0]][up[1]] != 1) {
                        queue.add(up);
                    }
                }
                if (down[0] < grid.length && grid[down[0]][down[1]] != 2 && distance[down[0]][down[1]] == -1) {
                    distance[down[0]][down[1]] = distance[curr[0]][curr[1]] + 1;
                    if (grid[down[0]][down[1]] != 1) {
                        queue.add(down);
                    }
                }
            }

            boolean shouldNotConsiderCurrSum = false;
            int currSum = 0;
            for (int[] building : buildings) {
                if (distance[building[0]][building[1]] == -1) {
                    shouldNotConsiderCurrSum = true;
                    break;
                }
                currSum += distance[building[0]][building[1]];
            }
            if (shouldNotConsiderCurrSum) {
                continue;
            }
            if (totalSum > currSum) {
                totalSum = currSum;
            }
        }
        if (totalSum == Integer.MAX_VALUE) {
            return -1;
        } else {
            return totalSum;
        }
    }
}
