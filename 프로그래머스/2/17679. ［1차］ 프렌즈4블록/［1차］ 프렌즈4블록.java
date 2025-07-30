class Solution {
    int answer = 0;
    int r=0;
    int c=0;
    public int solution(int m, int n, String[] board) {
        r=m;
        c=n;
        char [][] map=new char[m][n];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                map[i][j]=board[i].charAt(j);
            }
        }
        
        
        while(check(map)){
           blockMove(map);
        }
        return answer;
    }
    
    public boolean check(char[][]map){
        boolean checked=false;
        boolean [][]visited=new boolean[r][c];
        
        for(int i=0;i<r-1;i++){
            for(int j=0;j<c-1;j++){
                if(map[i][j]!='.'&&map[i][j]==map[i][j+1]&&map[i][j]==map[i+1][j+1]&&map[i][j]==map[i+1][j]){
                    visited[i][j]=true;
                    visited[i][j+1]=true;
                    visited[i+1][j]=true;
                    visited[i+1][j+1]=true; 
                    checked=true;
                }
            }
        }
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(visited[i][j]) {
                    answer ++;
                    map[i][j]='.';
                }
            }
        }
        
        return checked;
    }
    
    public void blockMove(char [][]map){
        for(int i=0;i<c;i++){
            for(int j=r-1;j>=1;j--){
                if(map[j][i]=='.'){
                    int len=1;
                    for(int k=j-1;k>=0;k--){
                        if(map[k][i]=='.'){
                            len++;
                            continue;
                        }
                        break;
                    }
                    for(int k=j;k-len>=0;k--){
                        map[k][i]=map[k-len][i];
                        map[k-len][i]='.';
                    }
                    
                }
            }
        }
    }
}