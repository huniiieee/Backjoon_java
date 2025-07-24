class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int len=sequence.length;
        
        int left=0;
        int right=0;
        int sum=sequence[0];
        int sequenceSize=Integer.MAX_VALUE;
        int resultLeft=0;
        int resultRight=0;
        
        while(left<=right){
            if(sum<k){
                right++;
                if(right==len) break;
                sum +=sequence[right];
            }
            else if(sum>k){
                sum -=sequence[left];
                left++;
            }
            else{
                int curSequenceSize=right-left+1;
                
                if(curSequenceSize<sequenceSize){
                    
                    sequenceSize=curSequenceSize;
                    resultLeft=left;
                    resultRight=right;
                }
                sum -=sequence[left];
                left++;
                
            }
        }
        
        answer[0]=resultLeft;
        answer[1]=resultRight;
        
        return answer;
    }
}