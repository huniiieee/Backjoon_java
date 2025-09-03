class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int [][] graph=new int[n+1][n+1];
        for(int i=0;i<results.length;i++){
            int winner=results[i][0];
            int loser=results[i][1];
            graph[winner][loser]=1;
            graph[loser][winner]=-1;
        }
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(i==j) continue;
                    if(graph[i][j]!=0) continue;
                    if(graph[i][k]==0 || graph[k][j] ==0) continue;
                    if(graph[i][k]!=graph[k][j]) continue;
                    graph[i][j]=graph[i][k];
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            boolean flag=true;
            for(int j=1;j<=n;j++){
                if(i==j) continue;
                if(graph[i][j]==0){
                    flag=false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}