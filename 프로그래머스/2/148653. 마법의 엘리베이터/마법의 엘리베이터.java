class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey!=0){
            int r=storey%10;
            storey=storey/10;
            if(r==0) continue;
            else if(r>5){
                storey +=1;
            }
            else if(r==5){
                if(storey%10>=5) storey +=1;
            }
            answer += Integer.min(r,10-r);
        }
        return answer;
    }
}