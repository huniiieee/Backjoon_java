class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        answer +=  cnt(1,stations[0]-w-1,2*w + 1); 
       for (int i = 1; i < stations.length; i++) {
           answer += cnt(stations[i-1] + w+1,stations[i]-w-1, 2*w + 1);
       }

        answer += cnt(stations[stations.length-1]+w+1,n,2*w + 1);

        return answer;
    }
    public int cnt(int start, int end, int w) {
        int dis = end-start+1;
        if (dis <= 0) {
            return 0;
        }
        if (dis % w == 0) {
            return (dis / w);
        } else {
            return (dis /w) + 1;
        }
    }
}