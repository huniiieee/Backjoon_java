import java.util.*;

class Solution {
    int []dx={0,-1,0,1};
    int []dy={-1,0,1,0};
    int answer=Integer.MAX_VALUE;
    boolean [][][]visited;
    public int solution(int[][] board) {
        int n=board.length;
        visited=new boolean[n][n][4];
        
        bfs(board);
        return answer;
    }
    
    public void bfs(int [][]board){
        Queue<int []> q=new LinkedList<>();
        q.offer(new int[]{0,0,-1,0}); // x,y,dir,cost
     
        while(!q.isEmpty()){
            int []cur=q.poll();
            int x=cur[0];
            int y=cur[1];
            int dir=cur[2];
            int cost=cur[3];
            
            if(x==board.length-1 && y==board.length-1){
                answer =Integer.min(answer,cost);
            }
            
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx<0||nx>=board.length||ny<0||ny>=board.length||board[nx][ny]==1)
                    continue;
                
            
                int nc=cost;
                if(dir==-1 ||dir==i) nc +=100;
                else nc +=600;
                
                if(!visited[nx][ny][i] || board[nx][ny]>=nc){
                    visited[nx][ny][i]=true;
                    board[nx][ny]=nc;
                    q.offer(new int[]{nx,ny,i,nc});
                }
                    
            }
            
            
        }
        
    }
}