import java.util.*;

class Solution {
    public int answer=0;
    public int cnt=0;
    public int solution(String word) {
        char []vowel=new char[]{'A','E','I','O','U'};
        backtrack(word,vowel,"");
        
        return answer;
    }
    
    public void backtrack(String word,char []vowel,String temp){
        
        if(temp.equals(word)){
            answer = cnt;
            return;
        }
        if(temp.length()==6)
            return;
        
        cnt ++;
        for(int i=0;i<5;i++){
            backtrack(word,vowel,temp + vowel[i]);
        }
        
        
    }
    
}