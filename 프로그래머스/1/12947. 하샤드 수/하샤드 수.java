class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int temp=x;
        int cnt=0;
        while(x!=0){
            cnt += (x%10);
            x /=10;
        }
        answer = (temp%cnt==0) ? true : false;
        return answer;
    }
}