class Solution {
    
    public String findDifferentBinaryString(String[] nums) {

        // There is a mathematical proof of Cantor's Diagonal Theorem in Set Theory. I do not know what it says. Learn it.
        return usingCantorsDiagonalProof(nums);

        // Enable this to use my solution
        // int[] list = new int[nums.length];
        // int i = 0;
        // for (String str : nums) {
        //     list[i++] = convertToInteger(str);
        // }

        // Arrays.sort(list);

        // int missingNumber = findTheMissingNumber(list);
        // return convertToString(missingNumber, nums.length);
    }

    private String usingCantorsDiagonalProof(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : strings) {
            stringBuilder.append(str.charAt(i++) == '1' ? '0' : '1');
        }
        return stringBuilder.toString();
    }

    // private String convertToString(int num, int size) {
    //     StringBuilder stringBuilder = new StringBuilder();

    //     do {
    //         int lsb = num & 1;
    //         num >>= 1;
    //         stringBuilder.append(lsb);
    //     } while (num != 0);

    //     while (stringBuilder.toString().length() != size) {
    //         stringBuilder.append(0);
    //     }
    //     return stringBuilder.reverse().toString();
    // }

    // private int findTheMissingNumber(int[] list) {
    //     int n = list.length;
    //     for (int i = 0; i < n; i++) {
    //         if (list[i] != i) {
    //             return i;
    //         }
    //     }
    //     return n;
    // }

    // private int convertToInteger(String str) {
    //     int value = 0;
    //     for (int i = str.length(); i > 0; i--) {
    //         int base = Integer.parseInt(str.substring(i - 1, i));
    //         value += (int) (base * Math.pow(2, str.length() - i));
    //     }
    //     return value;
    // }
}
