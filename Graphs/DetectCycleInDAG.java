#check for a node where it has visited twice in each path
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int[] visited=new int[adj.size()];
        Arrays.fill(visited,0);
        for(int i=0;i<adj.size();i++){
            if(visited[i]==0 && cycle(adj,visited,i)){
                return true;
            }
        }
        return false; 
    }
    public boolean cycle(ArrayList<ArrayList<Integer>> adj, int[] visited,int node){
        visited[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            if(visited[adj.get(node).get(i)]==1){
                return true;
            }
                if(cycle(adj,visited,adj.get(node).get(i))){
                    return true;
                }
            
        }
        visited[node]=0;
        return false;
    }
}
