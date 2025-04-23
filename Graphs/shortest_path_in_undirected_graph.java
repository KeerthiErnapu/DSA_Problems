class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1); // -1 means not reachable
        Queue<Integer> q = new ArrayDeque<>();

        q.add(src);
        dist[src] = 0; // Distance from src to src is 0

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int neighbor : adj.get(curr)) {
                if (dist[neighbor] == -1) { // Not visited yet
                    dist[neighbor] = dist[curr] + 1;
                    q.add(neighbor);
                }
            }
        }

        return dist;
    }
}
