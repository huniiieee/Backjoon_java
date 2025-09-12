class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        long [] dp=new long[n+1];
        dp[0]=1;
        
        for(int i=0;i<money.length;i++){
            int cur= money[i];
            
            for(int j=cur;j<=n;j++){
                dp[j] += dp[j-cur];
                dp[j] %=1000000007;
            }
        }
        return (int)dp[n];
    }
}