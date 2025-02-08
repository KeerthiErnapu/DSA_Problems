class Solution {
    public int kthElement(int a[], int b[], int k) {
        int i = 0, j = 0;
        int ans = -1;

        // Merge two sorted arrays until we reach the k-th element
        while (i < a.length && j < b.length && k > 0) {
            if (a[i] < b[j]) {
                ans = a[i++];
            } else {
                ans = b[j++];
            }
            k--;
        }

        // If elements are left in a[]
        while (i < a.length && k > 0) {
            ans = a[i++];
            k--;
        }

        // If elements are left in b[]
        while (j < b.length && k > 0) {
            ans = b[j++];
            k--;
        }

        return ans;
    }
}
