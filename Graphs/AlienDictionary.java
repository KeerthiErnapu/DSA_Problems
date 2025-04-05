//using topological sorting
class Solution {
    public String findOrder(String[] words) {
        int n = words.length;
        int K = 26;
        String ans = "";

        ArrayList<Integer>[] arr = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            arr[i] = new ArrayList<>();
        }

        // Step 1: Build adjacency list
        for (int i = 0; i < n - 1; i++) {
            String a = words[i];
            String b = words[i + 1];
            int j = 0;
            while (j < a.length() && j < b.length() && a.charAt(j) == b.charAt(j)) {
                j++;
            }
            if (j < a.length() && j < b.length()) {
                arr[a.charAt(j) - 'a'].add(b.charAt(j) - 'a');
            } else if (j < a.length() && j >= b.length()) {
                // Invalid case like "abc" before "ab"
                return "";
            }
        }

        // Step 2: Track present characters
        boolean[] present = new boolean[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        // Step 3: In-degree array
        int[] inorder = new int[K];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < arr[i].size(); j++) {
                inorder[arr[i].get(j)]++;
            }
        }

        // Step 4: Topological Sort
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            if (inorder[i] == 0 && present[i]) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int temp = q.poll();
            ans += (char)(temp + 'a');
            for (int next : arr[temp]) {
                inorder[next]--;
                if (inorder[next] == 0 && present[next]) {
                    q.add(next);
                }
            }
        }

        // Step 5: Cycle check
        int presentCount = 0;
        for (boolean b : present) {
            if (b) presentCount++;
        }

        if (ans.length() < presentCount) {
            return "";
        }

        return ans;
    }
}
