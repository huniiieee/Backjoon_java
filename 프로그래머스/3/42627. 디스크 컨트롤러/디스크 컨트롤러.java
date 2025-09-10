import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt((int[] j) -> j[1]) 
        );

        int idx = 0;        
        int curTime = 0;   
        int answer = 0;      
        int count = 0;      

        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= curTime) {
                pq.offer(jobs[idx]);
                idx++;
            }

            if (pq.isEmpty()) {
                curTime = jobs[idx][0];
                continue;
            }

            int[] cur = pq.poll();
            curTime += cur[1];                    
            answer += (curTime - cur[0]);           
            count++;
        }

        return answer / jobs.length;
    }
}
