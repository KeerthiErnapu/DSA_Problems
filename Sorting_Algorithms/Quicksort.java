class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quicksort(int[] nums, int s, int e) {
        if (s >= e) {
            return;
        }
        int pivot = partition(nums, s, e);
        quicksort(nums, s, pivot - 1);
        quicksort(nums, pivot + 1, e);
    }

    public static int partition(int[] nums, int l, int r) {
        int pivot = nums[r]; // Choosing the last element as pivot
        int pos = l; // Correct starting position

        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                // Swap nums[i] and nums[pos]
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
                pos++;
            }
        }

        // Swap pivot element to its correct position
        int temp = nums[pos];
        nums[pos] = nums[r];
        nums[r] = temp;

        return pos;
    }
}
