import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int [][]map=new int[rows][columns];
        int cnt=1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j]=cnt;
                cnt++;
            }
        }
        int len=queries.length;
        int[] answer = new int[len];
        
        for(int i=0;i<len;i++){
            int x1=queries[i][0]-1;
            int y1=queries[i][1]-1;
            int x2=queries[i][2]-1;
            int y2=queries[i][3]-1;
            answer[i]=rotate(x1,y1,x2,y2,map);
        }
        return answer;
    }
    
    public int rotate(int x1,int y1,int x2,int y2,int [][]map){
        Set<String> set=new HashSet<>();
        Queue<int []> q=new LinkedList<>();
        q.offer(new int[]{x1,y1});
        int pre=map[x1+1][y1];
        int min=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int []cur=q.poll();
            int x=cur[0];
            int y=cur[1];
            if(set.contains(x+","+y)) break;
            set.add(x+","+y);
            int temp=map[x][y];
            min=Integer.min(min,temp);
            map[x][y]=pre;
            pre=temp;
            int nx=x;
            int ny=y;
            if(y==y2&&x!=x2) nx=x+1;
            else if(x==x2&&y!=y1) ny=y-1;
            else if(y==y1&&x!=x1) nx=x-1;
            else ny=ny+1;
            q.offer(new int[]{nx,ny});
        }
        return min;
    }
}