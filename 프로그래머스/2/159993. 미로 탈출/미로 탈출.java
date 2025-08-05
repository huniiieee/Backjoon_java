import java.util.*;
class Solution {
    public int[] dx={0,1,0,-1};
    public int[] dy={1,0,-1,0};
    public int solution(String[] maps) {
        int r=maps.length;
        int c=maps[0].length();
        int startX=0;
        int startY=0;
        int endX=0;
        int endY=0;
        int leverX=0;
        int leverY=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                char temp=maps[i].charAt(j);
                if(temp=='S'){
                    startX=i;
                    startY=j;
                }
                else if(temp=='E'){
                    endX=i;
                    endY=j;
                }
                else if(temp=='L'){
                    leverX=i;
                    leverY=j;
                }
            }
        }
        
        int first=minDistance(startX,startY,leverX,leverY,maps);
        if(first==-1) return -1;
        int second=minDistance(leverX,leverY,endX,endY,maps);
        if(second==-1) return -1;
        
        return first+second;
    }
    
    public int minDistance(int startX,int startY,int endX,int endY,String[]maps){
        int r=maps.length;
        int c=maps[0].length();
        Queue<int []>queue=new LinkedList<>();
        queue.offer(new int[]{startX,startY,0});
        boolean [][]visited=new boolean[r][c];
        while(!queue.isEmpty()){
            int []cur=queue.poll();
            int x=cur[0];
            int y=cur[1];
            int cnt=cur[2];
            if(x==endX&&y==endY) return cnt;
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx<0||nx>=r||ny<0||ny>=c||visited[nx][ny]) continue;
                if(maps[nx].charAt(ny)=='X') continue;
                visited[nx][ny]=true;
                queue.offer(new int[]{nx,ny,cnt+1});
            }
        }
        return -1;
    }
}