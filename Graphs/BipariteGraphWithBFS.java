class Solution {
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int[] color=new int[adj.size()];
        Arrays.fill(color,-1);
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<adj.size();i++){
            if(color[i]==-1){
                q.add(i);
                color[i]=0;
               while(!q.isEmpty()){
                    int cur=q.poll();
                for(int j=0;j<adj.get(cur).size();j++){
                    if(color[adj.get(cur).get(j)]==-1){
                        color[adj.get(cur).get(j)]=(color[cur]+1)%2;
                        q.add(adj.get(cur).get(j));
                    }
                    else{
                        if(color[adj.get(cur).get(j)]==color[cur])
                        return false;
                    }
                }
               }
            }
        }
        return true;
    }
}
