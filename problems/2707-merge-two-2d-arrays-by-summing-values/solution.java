class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int size = sizeOfResultArray(nums1, nums2);
        int[][] result = new int[size][2];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                result[k] = new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]};
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                result[k] = nums1[i];
                i++;
            } else {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length) {
            result[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            result[k] = nums2[j];
            j++;
            k++;
        }

        return result;
    }

    private int sizeOfResultArray(int[][] nums1, int[][] nums2) {
        Set<Integer> idSet = new HashSet<>();
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < nums1.length; i++) {
            idSet.add(nums1[i][0]);
        }
        //noinspection ForLoopReplaceableByForEach
        for (int j = 0; j < nums2.length; j++) {
            idSet.add(nums2[j][0]);
        }
        return idSet.size();
    }
}
