class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder repeatedA = new StringBuilder(a);
        int count = 1; // We have added 'a' once

        // Keep appending 'a' until its length is at least 'b'
        while (repeatedA.length() < b.length()) {
            repeatedA.append(a);
            count++;
        }

        // Check if 'b' is already a substring
        if (repeatedA.toString().contains(b)) {
            return count;
        }

        // Append 'a' once more and check again
        repeatedA.append(a);
        count++;

        if (repeatedA.toString().contains(b)) {
            return count;
        }

        return -1;
    }
}
