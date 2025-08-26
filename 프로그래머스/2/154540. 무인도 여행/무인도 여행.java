import java.util.*;
class Solution {
    public int[] dx={-1,0,1,0};
    public int[] dy={0,1,0,-1};
    
    public List<Integer> solution(String[] maps) {
        List<Integer> answer=new LinkedList<>();
        char [][]charMaps=change(maps);
        int r=charMaps.length;
        int c=charMaps[0].length;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(charMaps[i][j]!='X'){
                    answer.add(sum(i,j,charMaps));
                }
            }
        }
        if(answer.size()==0) answer.add(-1);
        Collections.sort(answer);
        return answer;
    }
    
    
    public char [][] change(String []maps){
        int r=maps.length;
        int c=maps[0].length();
        char [][] temp=new char[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                temp[i][j]= maps[i].charAt(j);
            }
        }
        return temp;
    }
    public int sum (int r,int c,char [][]maps){
        Queue<int []> queue=new LinkedList<>();
        
        queue.offer(new int[]{r,c});
        int cnt= Character.getNumericValue(maps[r][c]);
        maps[r][c]='X';
        while(!queue.isEmpty()){
            int []cur=queue.poll();
            int x=cur[0];
            int y=cur[1];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx<0||nx>=maps.length||ny<0||ny>=maps[0].length||maps[nx][ny]=='X')
                    continue;
                
                queue.offer(new int[]{nx,ny});
                cnt +=Character.getNumericValue(maps[nx][ny]);
                maps[nx][ny]='X';
            }
        }
        return cnt;
    }
}