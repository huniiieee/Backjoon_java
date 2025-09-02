import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int len=operations.length;

        PriorityQueue<Integer> minQ= new PriorityQueue<>();
        PriorityQueue<Integer> maxQ= new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<len;i++){
            String operation=operations[i];
            String ope=operation.split(" ")[0];
            int num=Integer.parseInt(operation.split(" ")[1]);

            if(ope.equals("I")){
                minQ.offer(num);
                maxQ.offer(num);
                continue;
            }
            
            if(num==1&& !maxQ.isEmpty()){
                int removed=maxQ.poll();
                minQ.remove(removed);
            }
            else if(num==-1&& !minQ.isEmpty()){
                int removed=minQ.poll();
                maxQ.remove(removed);
            }
            
        }

        if(!maxQ.isEmpty()&& !minQ.isEmpty()){
            answer[0]=maxQ.poll();
            answer[1]=minQ.poll();
        }
        return answer;
    }
}