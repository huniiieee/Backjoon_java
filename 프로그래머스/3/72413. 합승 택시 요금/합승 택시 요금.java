import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int [][] floyd=new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                floyd[i][j]=100000*(n-1);
            }
        }
        for(int i=0;i<fares.length;i++){
            int start=fares[i][0];
            int end=fares[i][1];
            int fare=fares[i][2];
            floyd[start][end]=fare;
            floyd[end][start]=fare;
        }
        
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(i==j){
                        floyd[i][j]=0;
                        continue;
                    }                    
                    floyd[i][j]=Integer.min(floyd[i][j],floyd[i][k]+floyd[k][j]);
                }
            }
        }
        answer=floyd[s][a]+floyd[s][b];
        
        for(int i=1;i<n+1;i++){
            answer=Integer.min(answer,floyd[s][i]+floyd[i][a]+floyd[i][b]);
        }
        
        return answer;
    }
}