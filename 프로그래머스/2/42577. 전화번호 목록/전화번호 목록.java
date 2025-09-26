import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set=new HashSet<>();
        
        Arrays.sort(phone_book, (a,b)->a.length()-b.length());
        for(String s:phone_book){
            int len=s.length();
            for(int i=1;i<=len;i++){
                if(set.contains(s.substring(0,i))){
                    return false;
                }
            }
            set.add(s);
        }
        return answer;
    }
}