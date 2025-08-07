import java.util.*;
class Solution {
    public static int[]dx={-1,0,1,0};
    public static int[]dy={0,1,0,-1};
    public int solution(int[][] land) {
        int answer = 0;
        int r=land.length;
        int c=land[0].length;
        int []result=new int[c];
        bfs(land,result);
        
        for(int i:result){
            answer=Integer.max(answer,i);
        }
        return answer;
    }
    
    public void bfs(int [][]land,int []result){
        int r=land.length;
        int c=land[0].length;
        
        boolean [][]visited=new boolean[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(land[i][j]==0) continue;
                if(visited[i][j]) continue;
                
                Queue<int []> q=new LinkedList<>();
                Set<Integer> set=new HashSet<>();
                q.offer(new int[]{i,j});
                int cnt=0;
                visited[i][j]=true;
                while(!q.isEmpty()){
                    int []cur=q.poll();
                    int x=cur[0];
                    int y=cur[1];
                    cnt++;
                    set.add(y);
                    for(int k=0;k<4;k++){
                        int nx=x+dx[k];
                        int ny=y+dy[k];
                        if(nx<0||nx>=r||ny<0||ny>=c||visited[nx][ny]||land[nx][ny]==0) continue;
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny]=true;
                    }
                }
                for(int k:set){
                    result[k]+=cnt;
                }
            }
        }
    }
    
   
}