class Solution {
    
    int n=0;
    int maxNumber=0;
    int maxAmount=0;
    int []discounts={10,20,30,40};
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        n=emoticons.length;
        int []discountsAmount = new int[n];
        dfs(emoticons,users,discountsAmount,0);
        answer[0]=maxNumber;
        answer[1]=maxAmount;
        return answer;
    }
    
    
    public void dfs(int []emoticons,int [][]users,int []discountsAmount,int cnt){
        if(cnt==n){
            check(emoticons,users,discountsAmount);
            return;
        }
        
        for(int i=0;i<4;i++){
            discountsAmount[cnt]=discounts[i];
            dfs(emoticons,users,discountsAmount,cnt+1);
        }
    }
    
    public void check(int []emoticons,int [][]users,int []discountsAmount){
        int number=0;
        int amounts=0;
        int len=users.length;
        for(int i=0;i<len;i++){
            int amount=0;
            int dis=users[i][0];
            int money=users[i][1];
            for(int j=0;j<n;j++){
                if(dis<=discountsAmount[j])
                    amount +=(emoticons[j]/100*(100-discountsAmount[j]));
            }
            if(amount>=money) number++;
            else amounts +=amount;
        }
        if(number >maxNumber){
            maxNumber=number;
            maxAmount=amounts;
        }
        else if(number==maxNumber){
            maxAmount=Integer.max(maxAmount,amounts);
        }
    }
}