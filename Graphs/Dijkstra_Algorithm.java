class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        boolean[] explored = new boolean[V]; // explored[i] = true means node i is visited

        // Min-heap: stores {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src});

        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
            // If graph is undirected, also add: adj.get(v).add(new int[]{u, w});
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[1];

            if (explored[node]) continue; // Already processed this node
            explored[node] = true;

            for (int[] edge : adj.get(node)) {
                int neighbour = edge[0];
                int weight = edge[1];

                if (!explored[neighbour] && dist[neighbour] > dist[node] + weight) {
                    dist[neighbour] = dist[node] + weight;
                    pq.add(new int[]{dist[neighbour], neighbour});
                }
            }
        }

        return dist;
    }
}
