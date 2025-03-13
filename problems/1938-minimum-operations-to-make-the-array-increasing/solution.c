

int minOperations(int* nums, int numsSize){
    int ops = 0;
    int len = numsSize;
    int arr[len];
    for (int i = 0; i < len; i++) {
        arr[i] = nums[i];
    }
    for (int i = 1, prev = arr[0]; i < len; i++) {
        if (arr[i] <= prev) {
            ops += 1 + prev - arr[i];
            prev++;
        } else {
            prev = arr[i];
        }
    }
    return ops;
}
