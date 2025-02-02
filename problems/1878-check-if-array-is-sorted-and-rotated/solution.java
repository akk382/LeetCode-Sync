class Solution {
    public boolean check(int[] nums) {

        /*

        Let's consider the array is sorted

        Now, we find the index of an element where prev_elem > curr_elem;

        From that index onward, we traverse through the array (From i = curr_index + 1 to [(2*arrLen - 1) - (arrLen - curr_index)] + 1).

        We mod that index value with arrLen; i % arrLen; This way, we circle the array.

        Now we compare each elem and it should adher to a[i] <= a[i - 1]; 

        */

        int irregularIndex = findTheIrregularIndex(nums);
        if (irregularIndex == -1) { // The array is alreay sorted and shifted positions = 0;
            return true;
        }

        int searchUptoIndex = (2*nums.length - 1) - (nums.length - irregularIndex);
        for (int i = irregularIndex + 1; i <= searchUptoIndex; i++) {
            int mod_idx = i % nums.length;
            int prev_idx = (i - 1) % nums.length;
            if (nums[prev_idx] > nums[mod_idx]) {
                return false;
            }
        }

        return true;
        
    }

    private int findTheIrregularIndex(int nums[]) {

        int return_index = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                return_index = i;
                break;
            }
        }
        return return_index;
    }
}
