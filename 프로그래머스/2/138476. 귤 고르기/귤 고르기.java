import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int len=tangerine.length;
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<len;i++){
            if(map.containsKey(tangerine[i]))
                map.put(tangerine[i],map.get(tangerine[i])+1);
            else
                map.put(tangerine[i],1);
        }
    
        List<Integer>sortedValues=map.values()
            .stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        
        int sum=0;
        for(Integer i:sortedValues){
            sum +=i;
            answer++;
            if(sum>=k) break;
        }
                                
        return answer;
    }
}