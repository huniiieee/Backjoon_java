import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        Queue<int []> q=new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            int priority=priorities[i];
            q.offer(new int[]{i,priority});
            pq.offer(priority);
        }
        
        int curPriority=pq.poll();
        int answer = 0;
        while(!q.isEmpty()){
            int []cur= q.poll();
            int idx=cur[0];
            int priority=cur[1];
            
            if(curPriority!=priority){
                q.offer(cur);
                continue;
            }
            
            answer ++;
            if(idx==location){
                break;
            }
            curPriority=pq.poll();
        }
        
        return answer;
    }
}