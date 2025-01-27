import java.util.HashMap;

class Solution {
    int maxLen(int arr[]) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int res = 0;
        int sum = 0;
      

        // Initialize the map with a default sum of 0 at index -1
        h.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If the sum is already in the map
            if (h.containsKey(sum)) {
                // Update the maximum length
                res = Math.max(res, i - h.get(sum));
            } else {
                // Store the first occurrence of this sum
                h.put(sum, i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, -3, 3, 1, -4, 2, -2};
        System.out.println(solution.maxLen(arr)); // Output: 5
    }
}
