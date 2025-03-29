class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> ans=new ArrayList<>();
    int[] indegree=new int[adj.size()];
    Arrays.fill(indegree,0);
    for(int i=0;i<adj.size();i++){
        for(int j=0;j<adj.get(i).size();j++){
            indegree[adj.get(i).get(j)]++;
        }
    }
    Queue<Integer> q=new ArrayDeque<>();
    for(int i=0;i<adj.size();i++){
        if(indegree[i]==0){
            q.add(i);
        }
    }
    while(!q.isEmpty()){
        int temp=q.poll();
        ans.add(temp);
        for(int i=0;i<adj.get(temp).size();i++){
            indegree[adj.get(temp).get(i)]--;
            if(indegree[adj.get(temp).get(i)]==0){
                q.add(adj.get(temp).get(i));
            }
        }
    }
    return ans;
    }
}
