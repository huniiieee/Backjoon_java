class Solution {
    public long[] solution(long[] numbers) {
        int len=numbers.length;
        long[] answer = new long[len];
        for(int i=0;i<len;i++) answer[i]=nextNumber(numbers[i]);
        return answer;
    }
    
    public long nextNumber(long number){
        if(number%2==0)
            return number+1;
        
        long result=0;
        long q=number;
        
        long r=0;
        long temp=1;
        while(q!=0){
            r=q%2;
            q /=2;
            
            if(r==0){
                return number+temp-temp/2;
            }
            temp *=2;
        }
        return number+temp/2L;
    }
}