class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> ans=new ArrayList<>();
    Stack<Integer> st=new Stack<>();
    int[] visited=new int[adj.size()];
    Arrays.fill(visited,0);
    dfs(adj,visited,st,0);
    for(int i=0;i<adj.size();i++){
        if(visited[i]!=1){
            dfs(adj,visited,st,i);
        }
    }
    while(!st.isEmpty()){
        ans.add(st.pop());
    }
    return ans;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> st,int v){
        visited[v]=1;
        for(int i=0;i<adj.get(v).size();i++){
            if(visited[adj.get(v).get(i)]!=1){
                dfs(adj,visited,st,adj.get(v).get(i));
            }
        }
        st.push(v);
    }
}
