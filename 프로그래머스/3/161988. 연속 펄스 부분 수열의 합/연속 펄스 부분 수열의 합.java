class Solution {
    
    long answer = Long.MIN_VALUE;
    
    public long solution(int[] sequence) {
        
        int len=sequence.length;
        int []odd=new int[len];
        int []even=new int[len];
        
        for(int i=0;i<len;i=i+2){
            odd[i]=-sequence[i];
            even[i]=sequence[i];
        }
        for(int i=1;i<len;i=i+2){
            odd[i]=sequence[i];
            even[i]=-sequence[i];
        }
        
        long temp=0;
        for(int i=0;i<len;i++){
            if(temp+(long)odd[i]>=(long)odd[i]){
                temp +=(long)odd[i];
            }
            else{
                temp=odd[i];
            }
            answer=Long.max(temp,answer);
        }
        
        temp=0;
        for(int i=0;i<len;i++){
            if(temp+(long)even[i]>=(long)even[i]){
                temp +=(long)even[i];
            }
            else{
                temp=even[i];
            }
            answer=Long.max(temp,answer);
        }
        return answer;
    }
}