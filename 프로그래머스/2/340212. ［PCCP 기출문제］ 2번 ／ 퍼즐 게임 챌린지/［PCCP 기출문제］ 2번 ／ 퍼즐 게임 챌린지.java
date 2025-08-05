class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 1;
        int len=diffs.length;
        int max=0;
        for(int i=0;i<len;i++){
            max=Integer.max(max,diffs[i]);
        }
        
        int left=1;
        int right=max;
        
        
        while(left<=right){
            int mid=(left+right)/2;
            
            if(check(mid,diffs,times,limit)){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    
    public boolean check(int answer,int[]diffs,int[]times,long limit){
        boolean isPossible=true;
        long time=0;
        int len=diffs.length;
        int pre=times[0];
        int cur=times[0];
        for(int i=0;i<len;i++){
            cur=times[i];
            if(answer>=diffs[i]){
                time+=cur;
            }
            else{
                time +=(cur+pre)*(diffs[i]-answer);
                time +=cur;
            }
            if(time>limit){
                isPossible=false;
                break;
            }
            pre=times[i];
        }
        return isPossible;
    }
}