class Solution {
    public long solution(int w, int h) {      
        long answer = (long)w*(long)h;
        long gcd = gcd(w,h);
        long q1=(long)w/gcd;
        long q2=(long)h/gcd;
    
        long safe= (q1-1)*(q2-1);
        long remove= (q1*q2 -safe)*gcd;
        
        return answer-remove;
    }
    
    public long gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return (long)a;
    }
}