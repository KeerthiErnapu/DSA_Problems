class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        int r=grid.length;
        int c=grid[0].length;
        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    count++;
                    q.add(new int[]{i,j});
                    grid[i][j]='0';
                    
                    while(!q.isEmpty()){
                        int pair[]=q.poll();
                        int rno=pair[0];
                        int cno=pair[1];
                       //up
                        if(cno-1>=0 && grid[rno][cno-1]=='1'){
                            q.add(new int[]{rno,cno-1});
                            grid[rno][cno-1]='0';
                        }
                        //down
                        if(cno+1<c && grid[rno][cno+1]=='1'){
                            q.add(new int[]{rno,cno+1});
                            grid[rno][cno+1]='0';
                        }
                        //left
                        if( rno-1>=0 && grid[rno-1][cno]=='1'){
                            q.add(new int[]{rno-1,cno});
                            grid[rno-1][cno]='0';
                        }
                        //right
                        if( rno+1<r && grid[rno+1][cno]=='1'){
                            q.add(new int[]{rno+1,cno});
                            grid[rno+1][cno]='0';
                        }
                        //left up diagonal
                        if( rno-1>=0 && cno-1>=0 && grid[rno-1][cno-1]=='1'){
                            q.add(new int[]{rno-1,cno-1});
                            grid[rno-1][cno-1]='0';
                        }
                        //right up diagonal
                        if( rno-1>=0 && cno+1<c && grid[rno-1][cno+1]=='1'){
                            q.add(new int[]{rno-1,cno+1});
                            grid[rno-1][cno+1]='0';
                        }
                        //down left diagonal
                        if( cno-1>=0 && rno+1<r && grid[rno+1][cno-1]=='1'){
                            q.add(new int[]{rno+1,cno-1});
                            grid[rno+1][cno-1]='0';
                        }
                        //down right diagonal
                        if(cno+1<c && rno+1<r && grid[rno+1][cno+1]=='1'){
                            q.add(new int[]{rno+1,cno+1});
                            grid[rno+1][cno+1]='0';
                        }
                    }
                }
            }
        }
        return count;
    }
}
