import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer,Integer> map=new HashMap<>();
        Arrays.sort(weights);
        int len=weights.length;
        
        for(int i=len-1;i>=0;i--){
            int cur=weights[i];
            
            if(map.containsKey(cur)){
                answer += map.get(cur);
            }
             if(map.containsKey(cur*2)){
                answer += map.get(cur*2);
            }
            
            if(cur%2==0&&map.containsKey(cur*3/2)){
                answer += map.get(cur*3/2);
            }
            if(cur%3==0&&map.containsKey(cur*4/3)){
                answer += map.get(cur*4/3);
            }
            if(map.containsKey(cur)){
                map.put(cur,map.get(cur)+1);
            }
            else{
                map.put(cur,1);
            }
        }
        return answer;
    }
}