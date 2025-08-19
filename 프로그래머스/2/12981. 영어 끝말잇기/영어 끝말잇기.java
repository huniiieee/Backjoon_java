import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char pre=words[0].charAt(0);
        int cnt=0;
        Set<String> set=new HashSet<>();
        boolean flag=false;
        for(String word:words){
            if(pre!=word.charAt(0)){
                flag=true;
                break;
            }
            if(!set.add(word)){
                flag=true;
                break;
            }
            cnt++; 
            pre=word.charAt(word.length()-1);
        }
        if(flag){
            answer[0]=cnt%n+1;
            answer[1]=cnt/n+1;
        }
        System.out.print(cnt);
        return answer;
    }
}