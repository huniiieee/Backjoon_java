import java.util.Arrays;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int cur =0;
        Arrays.sort(targets, (t1,t2)->t1[1]-t2[1]);
        
        int len=targets.length;
        for(int i=0;i<len;i++){
            if(cur>targets[i][0]) continue;
            cur=targets[i][1];
            answer ++;
        }
        return answer;
    }
}