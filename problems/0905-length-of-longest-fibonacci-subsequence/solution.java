class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int max_length = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                int i1 = i;
                int j1 = j;
                int next_val = arr[i1] + arr[j1];
                int length = 2;
                while (map.containsKey(next_val)) {
                    length++;
                    i1 = j1;
                    j1 = map.get(next_val);
                    next_val = arr[i1] + arr[j1];
                    if (next_val > arr[arr.length - 1]) {
                        break;
                    }
                }
                if (length > max_length) {
                    max_length = length;
                }
            }
        }

        if (max_length == 2) {
            return 0;
        }

        return max_length;
    }
}
