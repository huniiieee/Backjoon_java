import java.util.Queue;
import java.util.LinkedList;
class Solution {
    int cacheHit=1;
    int cacheMiss=5;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue =new LinkedList<>();
        
        int len=cities.length;
        if(cacheSize==0){
            return cacheMiss*len;
        }
        for(int i=0;i<len;i++){
            String cur=cities[i].toUpperCase();
            if(queue.contains(cur)){
                answer +=cacheHit;
                queue.remove(cur);
                queue.offer(cur);
            }
            else{
                if(queue.size()==cacheSize) queue.poll();
                queue.offer(cur);    
                answer +=cacheMiss;
            }
        }
        
        return answer;
    }
}