class Solution {
    int answer=0;
    int solution(int[][] land) {
        int len = land.length;
        int dp[][]=new int[len][4];
        dp[0][0]=land[0][0];
        dp[0][1]=land[0][1];
        dp[0][2]=land[0][2];
        dp[0][3]=land[0][3];
        
        for(int i=1;i<len;i++){
            for(int j=0;j<4;j++){
                dp[i][j]= dp[i-1][(j+1)%4] + land[i][j];
                dp[i][j]=Integer.max(dp[i][j],dp[i-1][(j+2)%4] + land[i][j]);
                dp[i][j]=Integer.max(dp[i][j],dp[i-1][(j+3)%4] + land[i][j]);
                answer = Integer.max(answer,dp[i][j]);
            }
        }
        
        return answer;
    }
}