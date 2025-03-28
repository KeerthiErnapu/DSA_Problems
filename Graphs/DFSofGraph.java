class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        int V=adj.size();
       int[] visited=new int[V];
       Arrays.fill(visited,0);
      
       visited[0]=1;
       ArrayList<Integer> ans=new ArrayList<>();
       ans.add(0);
       dfs(adj,visited,ans,0);
       return ans;
        
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, ArrayList<Integer> ans,int v){
        for(int i=0;i<adj.get(v).size();i++){
            if(visited[adj.get(v).get(i)]!=1){
                visited[adj.get(v).get(i)]=1;
                ans.add(adj.get(v).get(i));
                dfs(adj,visited,ans,adj.get(v).get(i));
            }
        }
    }
}
