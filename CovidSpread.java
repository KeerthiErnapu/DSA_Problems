class Solution{
     public int helpaterp(int[][] hospital) {
    int r=hospital.length;
    int c=hospital[0].length;
     Queue<int[]> q = new LinkedList<>();
     for(int i=0;i<r;i++){
         for(int j=0;j<c;j++){
             if(hospital[i][j]==2){
                 q.offer(new int[]{i,j});
             }
         }
     }
     int timer=0;
     while(!q.isEmpty()){
         timer++;
         int s=q.size();
         for(int i=0;i<s;i++){
             int pair[]=q.poll();
             int rno=pair[0];
             int cno=pair[1];
             //left
             if( cno-1>=0 && hospital[rno][cno-1]==1){
                 hospital[rno][cno-1]=2;
                 q.offer(new int[]{rno,cno-1});
             }
             //right
             if( cno+1<c && hospital[rno][cno+1]==1){
                 hospital[rno][cno+1]=2;
                 q.offer(new int[]{rno,cno+1});
             }
             //up
             if( rno-1>=0 && hospital[rno-1][cno]==1){
                 hospital[rno-1][cno]=2;
                 q.offer(new int[]{rno-1,cno});
             }
             //down
             if( rno+1<r && hospital[rno+1][cno]==1){
                 hospital[rno+1][cno]=2;
                 q.offer(new int[]{rno+1,cno});
             }
         }
     }
     for(int i=0;i<r;i++){
         for(int j=0;j<c;j++){
             if(hospital[i][j]==1){
                 return -1;
             }
         }
     }
     if(timer==0){
         return 0;
     }
     return timer-1;
    }
}
