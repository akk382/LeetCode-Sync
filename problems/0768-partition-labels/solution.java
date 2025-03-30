class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int size = s.length();

        int[] elemLastPosMap = new int[26];
        Arrays.fill(elemLastPosMap, -1);

        for (int i = size - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (elemLastPosMap[ch - 'a'] == -1) {
                elemLastPosMap[ch - 'a'] = i;
            }
        }

        int prev = 0;
        int curr = 0;
        while (curr < size) {
            int until = elemLastPosMap[s.charAt(curr) - 'a'];
            for (; curr <= until; curr++) {
                int largestPosToIncludeUntil = elemLastPosMap[s.charAt(curr) - 'a'];
                if (largestPosToIncludeUntil > until) {
                    until = largestPosToIncludeUntil;
                }
            }
            result.add(curr - prev);
            prev = curr;
        }
        
        return result;
    }
}
