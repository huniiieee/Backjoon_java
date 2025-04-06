import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> q=new LinkedList<>();
        q.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(q.peekLast()!=arr[i]){
                q.add(arr[i]);
            }
        }
        int len=q.size();
        int []answer=new int[len];
        for(int i=0;i<len;i++){
            answer[i]=q.poll();
        }

        return answer;
    }
}