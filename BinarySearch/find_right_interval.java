import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startWithIndex = new int[n][2]; // {start, original index}

        // Fill array with {start, index}
        for (int i = 0; i < n; i++) {
            startWithIndex[i][0] = intervals[i][0];
            startWithIndex[i][1] = i;
        }

        // Sort by start time
        Arrays.sort(startWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];

            // Binary search to find the smallest start >= target
            int left = 0, right = n - 1, idx = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (startWithIndex[mid][0] >= target) {
                    idx = startWithIndex[mid][1]; // store candidate index
                    right = mid - 1; // search left part
                } else {
                    left = mid + 1; // search right part
                }
            }
            ans[i] = idx;
        }

        return ans;
    }
}
