import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int len=elements.length;
        int cLen=len+len-1;
        
        Set<Integer> sum=new HashSet<>();
        int []circle=new int[cLen];
        for(int i=0;i<len;i++){
            circle[i]=elements[i];
        }
        
        for(int i=len;i<cLen;i++){
            circle[i]=elements[i-len];
        }
        
        for(int i=1;i<=len;i++){
            for(int j=0;j<len;j++){
                int cnt=0;
                for(int k=0;k<i;k++){
                    cnt +=circle[j+k];
                }
                sum.add(cnt);
            }
        }
        
        return sum.size();
    }
    
}