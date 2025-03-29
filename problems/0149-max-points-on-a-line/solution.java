class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int localMax = 0;
            int inf = 1;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                
                if (dx == 0) {
                    inf += 1;
                    if (inf > localMax) {
                        localMax = inf;
                    }
                    continue;
                }

                double slope = (double) dy / dx;
                if (slope == -0.0) {
                    slope = 0.0;
                }         
                int newCount = map.getOrDefault(slope, 1) + 1;
                map.put(slope, newCount);
                if (newCount > localMax) {
                    localMax = newCount;
                }
            }
            if (localMax > max) {
                max = localMax;
            }
        }
        return max;
    }
}
