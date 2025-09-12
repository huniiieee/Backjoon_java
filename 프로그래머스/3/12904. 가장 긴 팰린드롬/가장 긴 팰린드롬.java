class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        for(int i=0;i<s.length()-1;i++){
            answer=Integer.max(answer,palindrome(s,i));
            if(s.charAt(i)==s.charAt(i+1)){
                answer = Integer.max(answer,palindrome(s,i,i+1));
            }
        }

        return answer;
    }
    
    public int palindrome(String s,int idx){
        int len=1;
        int left=idx;
        int right=idx;
        while(true){
            left -=1;
            right +=1;
            if(left<0 || right>=s.length()) break;
            
            if(s.charAt(left)!=s.charAt(right)) break;
            len +=2;
        }
        return len;
    }
    
    public int palindrome(String s, int idx1, int idx2){
        int len=2;
        int left=idx1;
        int right=idx2;
        while(true){
            left -=1;
            right +=1;
            if(left<0 || right>=s.length()) break;
            
            if(s.charAt(left)!=s.charAt(right)) break;
            len +=2;
        }
        return len;
    }
}