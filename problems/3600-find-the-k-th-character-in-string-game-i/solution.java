class Solution {
    int count = 0;
    public char kthCharacter(int k) {
        // find the k - (k / 2) * 2.
        // the abive result is the place in the first half and the char should be the char from first half + 1;
        // repeat this process until we get to length of first half as 1, which is 'a';
        // the result should be a + total could of iterations;

        if (k <= 1) {
            return (char)(97 + count);
        }
        count++;
        int indexInFirstHalf = k - (int)Math.pow(2, (int)(Math.log(k) / Math.log(2)));
        if (indexInFirstHalf == 0) {
            indexInFirstHalf = k / 2;
        }
        return kthCharacter(indexInFirstHalf);
    }
}
