class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        int[] visited = new int[V];
        visited[0] = 1;

        while (!q.isEmpty()) {
            int n = q.poll();
            ans.add(n);

            for (int i = 0; i < adj.get(n).size(); i++) {
                int neighbor = adj.get(n).get(i);
                if (visited[neighbor] == 0) {
                    visited[neighbor] = 1;
                    q.add(neighbor);
                }
            }
        }

        return ans;
    }
}
