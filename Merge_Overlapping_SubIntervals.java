import java.util.*;

class Solution {
    public int[][] merge(int[][] array) {
        // Step 1: Sort the array based on the first element of each interval
        Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));

        int n = array.length;
        ArrayList<int[]> ans = new ArrayList<>();
        
        // Step 2: Initialize the first interval
        int start = array[0][0];
        int end = array[0][1];

        // Step 3: Iterate through the intervals
        for (int i = 1; i < n; i++) {
            if (array[i][0] <= end) {
                // Overlapping intervals: Update the end to the maximum value
                end = Math.max(end, array[i][1]);
            } else {
                // No overlap: Add the current merged interval to the list
                ans.add(new int[]{start, end});
                // Start a new interval
                start = array[i][0];
                end = array[i][1];
            }
        }
        
        // Step 4: Add the last interval
        ans.add(new int[]{start, end});

        // Step 5: Convert the ArrayList to a 2D array
        return ans.toArray(new int[ans.size()][]);
    }
}
