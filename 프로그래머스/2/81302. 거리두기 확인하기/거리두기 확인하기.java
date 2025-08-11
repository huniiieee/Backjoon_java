import java.util.*;
class Solution {
    public static int []dx={0,-1,0,1};
    public static int []dy={-1,0,1,0};
    
    
    public int[] solution(String[][] places) {
        int len= places.length;
        int[] answer = new int[len];
        for(int i=0;i<5;i++){
            if(check(places[i])) answer[i]=1;
            else answer[i]=0;
        }
        
        return answer;
    }
    
    public boolean check(String []place){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(place[i].charAt(j)=='P'){
                    Queue<int []> q=new LinkedList<>();
                    boolean [][]visited =new boolean[5][5];
                    q.offer(new int[]{i,j,0});
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        int []cur=q.poll();
                        int x=cur[0];
                        int y=cur[1];
                        int cnt=cur[2];
                        if(cnt==3) break;
                        if(place[x].charAt(y)=='P'&&cnt>0){
                            return false;
                        }
                        for(int k=0;k<4;k++){
                            int nx=x+dx[k];
                            int ny=y+dy[k];
                            if(nx<0||nx>=5||ny<0||ny>=5||visited[nx][ny]||place[nx].charAt(ny)=='X') continue;
                            q.offer(new int[]{nx,ny,cnt+1});
                            visited[nx][ny]=true;
                        }
                    }
                }
            }
        }
        return true;
    }
}