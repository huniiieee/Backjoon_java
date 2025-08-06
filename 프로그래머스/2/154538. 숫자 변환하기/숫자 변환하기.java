import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<int []> q=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        q.offer(new int[]{x,0});
        while(!q.isEmpty()){
            int []cur=q.poll();
            int temp=cur[0];
            int cnt=cur[1];
            if(set.contains(temp)) continue;
            set.add(temp);
            if(temp==y){
                answer=cnt;
                break;
            }
            if(temp*3<=y){
                q.offer(new int[]{temp*3,cnt+1});
            }
            if(temp*2<=y){
                q.offer(new int[]{temp*2,cnt+1});
            }
            if(temp+n<=y)
                q.offer(new int[]{temp+n,cnt+1});
            
        }
        return answer;
    }
}