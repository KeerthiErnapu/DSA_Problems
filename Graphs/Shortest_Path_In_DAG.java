class Solution {
    public void dfs(int node, boolean[] visited, Stack<Integer> st, List<List<int[]>> adj) {
        visited[node] = true;
        for (int[] neighbor : adj.get(node)) {
            if (!visited[neighbor[0]]) {
                dfs(neighbor[0], visited, st, adj);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Step 1: Build the adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
        }

        // Step 2: Topological Sort using DFS
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, st, adj);
            }
        }

        // Step 3: Initialize distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;  // Source node is 0

        // Step 4: Relax edges in topological order
        while (!st.isEmpty()) {
            int u = st.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int wt = neighbor[1];
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Step 5: Replace unreachable nodes with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
