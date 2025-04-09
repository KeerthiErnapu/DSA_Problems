# using topological sorting technique
class Solution {
    public boolean isPossible(int N, int P, int[][] pre) {
        int[] indegree = new int[N]; // Store indegree of each node
        List<Integer>[] adj = new ArrayList[N]; // Adjacency list representation
        
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Build adjacency list & update indegree
        for (int i = 0; i < P; i++) {
            int u = pre[i][1], v = pre[i][0]; // Edge from u → v (v depends on u)
            adj[u].add(v);
            indegree[v]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        int count = 0; // To count processed nodes
        
        // Add all nodes with 0 indegree to queue
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        // Process BFS (Topological Sorting)
        while (!q.isEmpty()) {
            int ele = q.poll();
            count++; // Processed one node
            
            for (int neighbor : adj[ele]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        
        return count == N; // If we processed all nodes, return true
    }
}
