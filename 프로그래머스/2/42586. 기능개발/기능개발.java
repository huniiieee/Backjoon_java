import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> list = new LinkedList<>();
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++)
        {
            int dividend=100-progresses[i];
            int divisor=speeds[i];
            q.offer((int)Math.ceil((double)dividend/divisor));
        }
        
        while(!q.isEmpty())
        {   
            int cnt=1;
            int top=q.poll();
            while(!q.isEmpty()&&q.peek()<=top)
            {
                cnt++;
                q.poll();
            }
            list.add(cnt);
        }
        return list;
    }
}