class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> hMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hMap.put(s.charAt(i), hMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int evenMin = Integer.MAX_VALUE;
        int oddMax = 0;

        for (int val : hMap.values()) {
            if (val % 2 == 0) {
                evenMin = Math.min(evenMin, val);
            } else {
                oddMax = Math.max(oddMax, val);
            }
        }

        return oddMax - evenMin;
    }
}
