class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int len=queue1.length;
        int totalLen=len*2;
        int[] totalQueue=new int[totalLen];
        long sum1=0;
        long sum2=0;
        
        for(int i=0;i<len;i++){
            totalQueue[i]=queue1[i];
            totalQueue[i+len]=queue2[i];
            sum1 +=(long)queue1[i];
            sum2 +=(long)queue2[i];
        }
        long totalSum=sum1+sum2;
        if((totalSum)%2==1)
            return -1;
        
        int left=0;
        int right=len-1;
        int cnt=0;
        while(left<=right){
            if(sum1<sum2){
                right++;
                sum1 +=totalQueue[right%totalLen];
                sum2 -=totalQueue[right%totalLen];
            }
            else if(sum1>sum2){
                
                sum1 -=totalQueue[left%totalLen];
                sum2 +=totalQueue[left%totalLen];
                left++;
            }
            else{
                answer=cnt;
                break;
            }
            if(left > totalLen && right > totalLen) return -1;
            cnt++;
            
        }
        
        return answer;
    }
}