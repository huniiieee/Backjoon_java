import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer=0L;
        Queue<Integer> q=new PriorityQueue<>(Comparator.reverseOrder());
                
        for(int i=0;i<works.length;i++) q.offer(works[i]);
        
        for(int i=0;i<n;i++) q.offer(q.poll()-1);
        
        for(int i=0;i<works.length;i++){
            int cur=q.poll();
            if(cur <0) cur=0;
            answer += (long)(cur)*(long)(cur);
            
        }
            
        return answer;
    }
}