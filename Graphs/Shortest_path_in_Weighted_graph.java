class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Adjacency list to store graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w}); // Assuming it's an undirected graph, if not remove this line
        }

        // Distance array to store shortest distances
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        // Parent array to store the path
        int[] parent = new int[n + 1];
        parent[1] = -1;

        // Explored array to track processed nodes
        int[] explored = new int[n + 1];

        // PriorityQueue to implement the Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, 1});  // Distance and node

        // Dijkstra's Algorithm with explored array
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0];
            int node = current[1];

            // If the node is already fully explored, skip processing
            if (explored[node] == 1) continue;

            // Mark the node as explored
            explored[node] = 1;

            // Relax edges
            for (int[] x : adj.get(node)) {
                int neighbour = x[0];
                int weight = x[1];
                // If a shorter path is found, update distance and parent
                if (dist[neighbour] > dist[node] + weight) {
                    dist[neighbour] = dist[node] + weight;
                    pq.add(new int[]{dist[neighbour], neighbour});
                    parent[neighbour] = node;
                }
            }
        }

        // Prepare path from parent array
        List<Integer> path = new ArrayList<>();

        // If the destination node has not been updated, no path exists
        if (dist[n] == Integer.MAX_VALUE) {
            path.add(-1); // Return -1 if no path exists
            return path;
        }

        // Reconstruct the path by going from destination to source
        int dest = n;
        while (dest != -1) {
            path.add(dest);
            dest = parent[dest];
        }

        // Add the distance at the end of the path
        path.add(dist[n]);

        // Reverse the path to get the correct order
        Collections.reverse(path);

        return path;
    }
}

