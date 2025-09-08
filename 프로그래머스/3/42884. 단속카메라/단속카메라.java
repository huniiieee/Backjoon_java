import java.util.Arrays;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int cur=-30001;
        Arrays.sort(routes,(a,b)->a[1]-b[1]);
        for(int i=0;i<routes.length;i++){
            if(routes[i][0]<=cur) continue;
            else{
                answer++;
                cur=routes[i][1];
            }
        }
        return answer;
    }
}