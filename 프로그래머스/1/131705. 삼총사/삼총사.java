import java.util.*;
class Solution {
    int answer=0;
    public int solution(int[] number) {
        List<Integer>temp=new LinkedList<>();
        dfs(number,temp,0,0);
        return answer;
    }
    public void dfs(int []number, List<Integer> temp,int start,int cnt){
        if(cnt==3){
            int sum=number[temp.get(0)]+number[temp.get(1)]+number[temp.get(2)];
            if(sum==0) answer +=1;
            return;
        }
        
        for(int i=start;i<number.length;i++){
            temp.add(i);
            dfs(number,temp,i+1,cnt+1);
            temp.remove(temp.size()-1);
        }
    }
}