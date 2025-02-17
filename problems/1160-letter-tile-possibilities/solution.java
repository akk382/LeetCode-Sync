class Solution {
    public int numTilePossibilities(String tiles) {
         Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            int count = 1 + frequencies.getOrDefault(tiles.charAt(i), 0);
            frequencies.put(tiles.charAt(i), count);
        }

        return recurse(frequencies);
    }

    private int recurse(Map<Character, Integer> frequencies) {
        AtomicInteger sum = new AtomicInteger(0);
        frequencies.keySet().forEach(key -> {
            Integer val = frequencies.get(key);
            if (val > 0) {
                frequencies.put(key, val - 1);
                sum.set(sum.get() + 1 + recurse(frequencies));
                frequencies.put(key, val);
            }
        });
        return sum.get();
    }
}
