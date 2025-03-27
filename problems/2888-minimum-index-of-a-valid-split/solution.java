class Solution {
    public int minimumIndex(List<Integer> nums) {

        // find the dominant element
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }
        int max = -1;
        int dominantValue = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                dominantValue = entry.getKey();
            }
        }

        int[] track = new int[nums.size()];
        int count = 0;

        if (nums.get(0) == dominantValue) {
            track[0] = 1;
        } else {
            track[0] = 0;
        }
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == dominantValue) {
                track[i] = track[i - 1] + 1;
            } else {
                track[i] = track[i - 1];
            }
        }

        for (int i = 0; i < track.length; i++) {
            if (track[i] > (i + 1) / 2 && track[track.length - 1] - track[i] > (track.length - 1 - i) / 2) {
                return i;
            }
        }

        return -1;        
    }
}
