class Solution {
    public String getHappyString(int n, int k) {
        char[] use = getToUseList('y');
        int[] acc = new int[1];
        String[] res = new String[1];
        res[0] = "";
        getHappyString(n, k, acc, use, "", res);
        return res[0];
    }

    private int getHappyString(int n, int k, int[] acc, char[] use, String string, String[] res) {

        if (n == 0) {
            acc[0] = acc[0] + 1;
            if (acc[0] == k) {
                res[0] = string;
                return 0;
            }
            return -1;
        }

        for (final char using : use) {
            if (getHappyString(n - 1, k, acc, getToUseList(using), string + using, res) == 0) {
                return 0;
            }
        }
        return -1;
    }

    private char[] getToUseList(char prevUsed) {
        return switch (prevUsed) {
            case 'a' -> new char[]{'b', 'c'};
            case 'b' -> new char[]{'a', 'c'};
            case 'c' -> new char[]{'a', 'b'};
            default -> new char[]{'a', 'b', 'c'};
        };
    }
}
