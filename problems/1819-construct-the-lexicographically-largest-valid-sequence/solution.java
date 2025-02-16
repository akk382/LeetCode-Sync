class Solution {

    // refer to video: https://www.youtube.com/watch?v=9xSx0t4SFS8
    
    public int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1;
        int[] seq = new int[len];
        Arrays.fill(seq, -1);
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        recursion(seq, visited, 0, n);
        return seq;
    }

    private boolean recursion(int[] seq, boolean[] visited, int curPos, int n) {

        // Find the elem can fit in the curPos:
        // If found, and if it can fit, place it, and mark it as visited find next free slot and recurse
        // If not found backtrack and recurse
        // return true if we reached the point where we were able to place 0 once.
        // else return false.

        if (curPos == seq.length) {
            return true;
        }
        if (seq[curPos] != -1) {
            return recursion(seq, visited, curPos + 1, n);
        }

        int i = n;
        while (i > 0) {
            if (visited[i]) {
                i--;
                continue;
            }
            seq[curPos] = i;
            visited[i] = true;
            if (i == 1 && recursion(seq, visited, curPos + 1, n)) {
                return true;
            }
            if (i > 1 && curPos + i < seq.length && seq[curPos + i] == -1) {
                seq[curPos + i] = i;
                if (recursion(seq, visited, curPos + 1, n)) {
                    return true;
                }
                seq[curPos + i] = -1;
            }
            seq[curPos] = -1;
            visited[i] = false;
            i--;
        }

        return false;

    }
}
